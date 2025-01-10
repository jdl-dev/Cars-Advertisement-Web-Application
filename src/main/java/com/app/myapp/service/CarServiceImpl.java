package com.app.myapp.service;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.mapper.CarMapper;
import com.app.myapp.model.model.Car;
import com.app.myapp.model.model.carmembers.Bodytype;
import com.app.myapp.model.model.carmembers.Brand;
import com.app.myapp.model.model.carmembers.ColorPalette;
import com.app.myapp.model.model.carmembers.Gearbox;
import com.app.myapp.model.model.carmembers.Petrol;
import com.app.myapp.model.model.carmembers.State;
import com.app.myapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.function.Supplier;

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
        int price = carDto.getPrice();
        int minPrice = searchRangeDto.getPriceRangeDto().getMinPrice();
        int maxPrice = searchRangeDto.getPriceRangeDto().getMaxPrice();
        if (!compareValueIfItsInGivenRange(price, minPrice, maxPrice)) {
            return false;
        }

        int mileage = carDto.getMileage();
        int minMileage = searchRangeDto.getMileageRangeDto().getMinMileage();
        int maxMileage = searchRangeDto.getMileageRangeDto().getMaxMileage();
        if (!compareValueIfItsInGivenRange(mileage, minMileage, maxMileage)) {
            return false;
        }

        int displacement = carDto.getDisplacement();
        int minDisplacement = searchRangeDto.getDisplacementRangeDto().getMinDisplacement();
        int maxDisplacement = searchRangeDto.getDisplacementRangeDto().getMaxDisplacement();
        if (!compareValueIfItsInGivenRange(displacement, minDisplacement, maxDisplacement)) {
            return false;
        }

        int power = carDto.getPower();
        int minPower = searchRangeDto.getPowerRangeDto().getMinPower();
        int maxPower = searchRangeDto.getPowerRangeDto().getMaxPower();
        if (!compareValueIfItsInGivenRange(power, minPower, maxPower)) {
            return false;
        }

        int yearOfProduction = Integer.parseInt(carDto.getYearOfProduction().toString());
        int minYearOfProduction = searchRangeDto.getYearOfProductionRangeDto().getMinYearOfProduction();
        int maxYearOfProduction = searchRangeDto.getYearOfProductionRangeDto().getMaxYearOfProduction();
        if (!compareValueIfItsInGivenRange(yearOfProduction, minYearOfProduction, maxYearOfProduction)) {
            return false;
        }

        int doors = carDto.getDoorNumber();
        int minDoors = searchRangeDto.getDoorsRangeDto().getMinDoorNumber();
        int maxDoors = searchRangeDto.getDoorsRangeDto().getMaxDoorNumber();
        if (!compareValueIfItsInGivenRange(doors, minDoors, maxDoors)) {
            return false;
        }

        int seats = carDto.getAmountOfSeats();
        int minSeats = searchRangeDto.getSeatsRangeDto().getMinAmountOfSeats();
        int maxSeats = searchRangeDto.getSeatsRangeDto().getMaxAmountOfSeats();
        if (!compareValueIfItsInGivenRange(seats, minSeats, maxSeats)) {
            return false;
        }

        var color = carDto.getColor();
        List<ColorPalette> colors = searchRangeDto.getColors();
        if (!colors.contains(color)) {
            return false;
        }

        var state = carDto.getState();
        List<State> states = searchRangeDto.getStates();
        if (!states.contains(state)) {
            return false;
        }

        var brand = carDto.getBrand();
        List<Brand> brands = searchRangeDto.getBrands();
        if (!brands.contains(brand)) {
            return false;
        }

        var petrolType = carDto.getPetrol();
        List<Petrol> petrolTypes = searchRangeDto.getPetrolTypes();
        if (!petrolTypes.contains(petrolType)) {
            return false;
        }

        var gearboxType = carDto.getGearbox();
        List<Gearbox> gearboxTypes = searchRangeDto.getGearboxTypes();
        if (!gearboxTypes.contains(gearboxType)) {
            return false;
        }

        var bodyType = carDto.getBodytype();
        List<Bodytype> bodyTypes = searchRangeDto.getBodytypeList();
        if (!bodyTypes.contains(bodyType)) {
            return false;
        }

        return true;
    }

    private boolean compareValueIfItsInGivenRange(int value, int minValue, int maxValue) {
        return value >= minValue && value <= maxValue;
    }

    public CarDto updateCar(long id, CarDto carDto) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car with given id doesn't exist"));

        boolean isChanged = false;

        int oldPrice = car.getPrice();
        int newPrice = carDto.getPrice();
        if (!(oldPrice == newPrice)) {
            car.setPrice(newPrice);
            isChanged = true;
        }

        int oldMileage = car.getMileage();
        int newMileage = carDto.getMileage();
        if (!(oldMileage == newMileage)) {
            car.setMileage(newMileage);
            isChanged = true;
        }

        int oldDisplacement = car.getDisplacement();
        int newDisplacement = carDto.getDisplacement();
        if (!(oldDisplacement == newDisplacement)) {
            car.setDisplacement(newDisplacement);
            isChanged = true;
        }

        int oldPower = car.getPower();
        int newPower = carDto.getPower();
        if (!(oldPower == newPower)) {
            car.setPower(newPower);
            isChanged = true;
        }

        String oldDescription = car.getDescription();
        String newDescription = carDto.getDescription();
        if (!oldDescription.equals(newDescription)) {
            car.setDescription(newDescription);
            isChanged = true;
        }

        Year oldYearOfProduction = car.getYearOfProduction();
        Year newYearOfProduction = carDto.getYearOfProduction();
        if (!(oldYearOfProduction.compareTo(newYearOfProduction) == 0)) {
            car.setYearOfProduction(newYearOfProduction);
            isChanged = true;
        }

        int oldDoorsNumber = car.getDoorNumber();
        int newDoorsNumber = carDto.getDoorNumber();
        if (!(oldDoorsNumber == newDoorsNumber)) {
            car.setDoorNumber(newDoorsNumber);
            isChanged = true;
        }

        int oldAmountOfSeats = car.getAmountOfSeats();
        int newAmountOfSeats = carDto.getAmountOfSeats();
        if (!(oldAmountOfSeats == newAmountOfSeats)) {
            car.setAmountOfSeats(newAmountOfSeats);
            isChanged = true;
        }

        if (isChanged) {
            car.setDateOfUpdatingTheAdd(carDto.getDateOfUpdatingTheAdd());
        }

        if (isChanged) {
            carRepository.save(car);
        }

        return CarMapper.toDto(car);
    }

    @Override
    public CarDto deleteCar(long id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car with given id doesn't exist"));

        carRepository.deleteById(id);
        return CarMapper.toDto(car);
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