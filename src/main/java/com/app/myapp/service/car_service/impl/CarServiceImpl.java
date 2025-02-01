package com.app.myapp.service.car_service.impl;

import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import com.app.myapp.exception.CarNotFoundException;
import com.app.myapp.exception.DatabaseConnectionException;
import com.app.myapp.exception.InvalidCarException;
import com.app.myapp.mapper.CarMapper;
import com.app.myapp.model.model.Car;
import com.app.myapp.repository.CarRepository;
import com.app.myapp.service.car_service.service.CarService;
import com.app.myapp.service.car_service.utils.RestPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarUtilsImpl serviceUtils;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper, CarUtilsImpl serviceUtils1, CarUtilsImpl carUtilsImpl) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.serviceUtils = serviceUtils1;
    }

    @Override
    public CarResponseDto saveCar(CarCreateDto createdCarDto) {
        Car carToSave =
                carMapper
                        .carCreateDtoToEntity(createdCarDto);

        try {
            Car savedCar =
                    carRepository
                            .save(carToSave);

            return carMapper
                    .carEntityToResponseDto(savedCar);

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when saving the car.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while saving the car.");
        }
    }

    @Override
    public List<CarResponseDto> addManyCars(List<CarCreateDto> createdCarsDtos) {
        List<Car> cars =
                createdCarsDtos
                        .stream()
                        .map(carMapper::carCreateDtoToEntity)
                        .toList();
        try {

            List<Car> savedCars =
                    carRepository
                            .saveAll(cars);

            return savedCars
                    .stream()
                    .map(carMapper::carEntityToResponseDto)
                    .toList();

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when saving the list of cars.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while saving the list of cars.");
        }
    }

    @Cacheable(cacheNames = "getCarById")
    @Override
    public CarResponseDto getCarById(long id) {
        try {

            Car carFromDatabaseFoundById =
                    carRepository
                            .findById(id)
                            .orElseThrow(() -> new CarNotFoundException("Car with given id doesn't exist: " + id));

            CarResponseDto carResponseDto =
                    carMapper
                            .carEntityToResponseDto(carFromDatabaseFoundById);

            return carResponseDto;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when retrieving car by id from database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while retrieving car by id from database.");
        }
    }

    @Cacheable(cacheNames = "allCars")
    @Override
    public List<CarResponseDto> getAllCars() {
        try {

            List<Car> cars =
                    carRepository
                            .findAll();

            List<CarResponseDto> carResponseDtos =
                    cars
                            .stream()
                            .map(carMapper::carEntityToResponseDto)
                            .toList();

            return carResponseDtos;

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when retrieving all cars from database.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while retrieving all cars from database.");
        }
    }

    @Cacheable(cacheNames = "carsPage")
    @Override
    public Page<CarResponseDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int size, String sortBy, String order) {
        SearchRangeDto finalSearchRangeDto =
                Objects.isNull(searchRangeDto) ?
                        new SearchRangeDto() :
                        searchRangeDto;

        try {
            Pageable pageRequest =
                    PageRequest
                            .of(page, size, Sort.by(Sort.Direction.fromString(order), sortBy));

            Page<Car> carsPageEntities =
                    carRepository
                            .findAll(pageRequest);

            List<CarResponseDto> carResponseDtos =
                    carsPageEntities
                            .getContent()
                            .stream()
                            .filter(car -> serviceUtils.filterCarsForUserWithGivenSearchRangeBounds(car, finalSearchRangeDto))
                            .map(carMapper::carEntityToResponseDto)
                            .toList();

            int total = carResponseDtos.size();

            return new RestPage<>(carResponseDtos, page, size, total);

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when retrieving cars from given range.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while retrieving cars from given range.");
        }
    }

    @Override
    public CarResponseDto updateCar(long id, CarUpdateDto carPropertiesToUpdate) {
        try {
            Car carFromDatabaseToBeUpdated = carRepository
                    .findById(id)
                    .orElseThrow(() -> new CarNotFoundException("Car with given id doesn't exist: " + id));

            if (carPropertiesToUpdate == null) {
                throw new InvalidCarException("Updating car data is not correct.");
            }

            if (!serviceUtils.hasAtLeastOneNonNullProperty(carPropertiesToUpdate)) {
                throw new InvalidCarException("No properties to update.");
            }

            if (!serviceUtils.isDateOfUpdatingTheAddValid(carPropertiesToUpdate)) {
                throw new InvalidCarException("Date of updating advertisement is not correct.");
            }



            carFromDatabaseToBeUpdated = serviceUtils
                    .updatingCarWithNewDataFromUser(carFromDatabaseToBeUpdated, carPropertiesToUpdate);

            Car updatedAndSavedCar = carRepository.save(carFromDatabaseToBeUpdated);

            return carMapper
                    .carEntityToResponseDto(updatedAndSavedCar);


        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when updating car.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while updating car.");
        }
    }


    @Override
    public CarResponseDto deleteCar(long id) {
        try {

            Car deletedCar = carRepository
                    .findById(id)
                    .orElseThrow(() -> new CarNotFoundException("Car with given id doesn't exist: " + id));

            carRepository.deleteById(id);

            return carMapper.carEntityToResponseDto(deletedCar);

        } catch (DataAccessException exception) {
            throw new DatabaseConnectionException("Failed due to problems with database when deleting car.");
        } catch (Exception exception) {
            throw new RuntimeException("A unexpected error occurred while deleting car.");
        }
    }
}