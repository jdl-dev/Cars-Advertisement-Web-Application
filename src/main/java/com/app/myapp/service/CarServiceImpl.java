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
    public Car addCar(CarDto carDto) {
        return carRepository.save(CarMapper.toEntity(carDto));
    }

    @Override
    public List<Car> addManyCars(List<CarDto> carDtoList) {
        List<Car> cars = carDtoList.stream()
                .map(CarMapper::toEntity)
                .toList();

        return carRepository.saveAll(cars);
    }

    @Override
    public List<Car> getAllCarsFromDB() {
        return carRepository.findAll();
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
        if (carDto.getPrice() >= searchRangeDto.getPriceRangeDto().getMinPrice() &&
                carDto.getPrice() <= searchRangeDto.getPriceRangeDto().getMaxPrice()) {
            return true;
        }

        if (carDto.getMileage() >= searchRangeDto.getMileageRangeDto().getMinMileage() &&
                carDto.getMileage() <= searchRangeDto.getMileageRangeDto().getMaxMileage()) {
            return true;
        }

        return false;
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