package com.app.myapp.service;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.mapper.CarMapper;
import com.app.myapp.model.model.Car;
import com.app.myapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto addCar(CarDto carDto) {
        carRepository.save(CarMapper.toEntity(carDto));
        return carDto;
    }

    @Override
    public List<CarDto> addManyCars(List<CarDto> carDtoList) {
        List<Car> cars = carDtoList.stream()
                .map(CarMapper::toEntity)
                .toList();

        List<Car> cars1 = carRepository.saveAll(cars);

        return cars1.stream()
                .map(CarMapper::toDto)
                .toList();
    }

    @Override
    public List<CarDto> getAllCarsFromDB() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(CarMapper::toDto).toList();
    }

    @Override
    public List<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto) {
        List<CarDto> carDtoList = carRepository.findAll().stream()
                .map(CarMapper::toDto)
                .toList();

        return carDtoList.stream()
                .filter(carDto -> filterCarsForUserWithGivenSearchRangeBounds(carDto, searchRangeDto))
                .toList();
    }

    private boolean filterCarsForUserWithGivenSearchRangeBounds(CarDto carDto, SearchRangeDto searchRangeDto) {
        if (carDto.getPrice() <= searchRangeDto.getPriceRangeDto().getMinPrice() ||
                carDto.getPrice() >= searchRangeDto.getPriceRangeDto().getMaxPrice()) {
            return false;
        }

        if (carDto.getMileage() <= searchRangeDto.getMileageRangeDto().getMinMileage() ||
                carDto.getMileage() >= searchRangeDto.getMileageRangeDto().getMaxMileage()) {
            return false;
        }

        //TODO

        return true;
    }

    /*
    @Override
    public Car saveCar(CarDto carDto) {
        return null;
    }

    @Override
    public List<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto) {
        return List.of();
    }

    @Override
    public Car updateCar(int id, CarDto carDto) {
        return null;
    }

    @Override
    public Car deleteCar(int id) {
        return null;
    }
   */
}