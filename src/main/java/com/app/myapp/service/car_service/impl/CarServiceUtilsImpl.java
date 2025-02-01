package com.app.myapp.service.car_service.impl;

import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import com.app.myapp.model.model.Car;
import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import com.app.myapp.service.car_service.utils.CarServiceUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class CarServiceUtilsImpl implements CarServiceUtils {
    public Car updatingCarWithNewDataFromUser(Car carToBeUpdated, CarUpdateDto carWithUpdatingData) {
        if (isPropertyToUpdate(carWithUpdatingData.getPrice())) {
            carToBeUpdated.setPrice(carWithUpdatingData.getPrice());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getMileage())) {
            carToBeUpdated.setMileage(carWithUpdatingData.getMileage());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getDisplacement())) {
            carToBeUpdated.setDisplacement(carWithUpdatingData.getDisplacement());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getPower())) {
            carToBeUpdated.setPower(carWithUpdatingData.getPower());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getDescription())) {
            carToBeUpdated.setDescription(carWithUpdatingData.getDescription());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getDateOfUpdatingTheAdd())) {
            carToBeUpdated.setDateOfUpdatingTheAdd(carWithUpdatingData.getDateOfUpdatingTheAdd());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getYearOfProduction())) {
            carToBeUpdated.setYearOfProduction(carWithUpdatingData.getYearOfProduction());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getDoorNumber())) {
            carToBeUpdated.setDoorNumber(carWithUpdatingData.getDoorNumber());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getAmountOfSeats())) {
            carToBeUpdated.setAmountOfSeats(carWithUpdatingData.getAmountOfSeats());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getVin())) {
            carToBeUpdated.setVin(carWithUpdatingData.getVin());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getColor())) {
            carToBeUpdated.setColor(carWithUpdatingData.getColor());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getState())) {
            carToBeUpdated.setState(carWithUpdatingData.getState());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getBrand())) {
            carToBeUpdated.setBrand(carWithUpdatingData.getBrand());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getPetrol())) {
            carToBeUpdated.setPetrol(carWithUpdatingData.getPetrol());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getGearbox())) {
            carToBeUpdated.setGearbox(carWithUpdatingData.getGearbox());
        }

        if (isPropertyToUpdate(carWithUpdatingData.getBodytype())) {
            carToBeUpdated.setBodytype(carWithUpdatingData.getBodytype());
        }

        return carToBeUpdated;
    }

    private <T> boolean isPropertyToUpdate(T property) {
        return Objects.nonNull(property);
    }

    @Override
    public boolean filterCarsForUserWithGivenSearchRangeBounds(Car car, SearchRangeDto searchRangeDto) {
        int price = car.getPrice();
        int minPrice = searchRangeDto.getPriceRangeDto().getMinPrice();
        int maxPrice = searchRangeDto.getPriceRangeDto().getMaxPrice();
        if (!compareValueIfItsInGivenRange(price, minPrice, maxPrice)) {
            return false;
        }

        int mileage = car.getMileage();
        int minMileage = searchRangeDto.getMileageRangeDto().getMinMileage();
        int maxMileage = searchRangeDto.getMileageRangeDto().getMaxMileage();
        if (!compareValueIfItsInGivenRange(mileage, minMileage, maxMileage)) {
            return false;
        }

        int displacement = car.getDisplacement();
        int minDisplacement = searchRangeDto.getDisplacementRangeDto().getMinDisplacement();
        int maxDisplacement = searchRangeDto.getDisplacementRangeDto().getMaxDisplacement();
        if (!compareValueIfItsInGivenRange(displacement, minDisplacement, maxDisplacement)) {
            return false;
        }

        int power = car.getPower();
        int minPower = searchRangeDto.getPowerRangeDto().getMinPower();
        int maxPower = searchRangeDto.getPowerRangeDto().getMaxPower();
        if (!compareValueIfItsInGivenRange(power, minPower, maxPower)) {
            return false;
        }

        int yearOfProduction = Integer.parseInt(car.getYearOfProduction().toString());
        int minYearOfProduction = searchRangeDto.getYearOfProductionRangeDto().getMinYearOfProduction();
        int maxYearOfProduction = searchRangeDto.getYearOfProductionRangeDto().getMaxYearOfProduction();
        if (!compareValueIfItsInGivenRange(yearOfProduction, minYearOfProduction, maxYearOfProduction)) {
            return false;
        }

        int doors = car.getDoorNumber();
        int minDoors = searchRangeDto.getDoorsRangeDto().getMinDoorNumber();
        int maxDoors = searchRangeDto.getDoorsRangeDto().getMaxDoorNumber();
        if (!compareValueIfItsInGivenRange(doors, minDoors, maxDoors)) {
            return false;
        }

        int seats = car.getAmountOfSeats();
        int minSeats = searchRangeDto.getSeatsRangeDto().getMinAmountOfSeats();
        int maxSeats = searchRangeDto.getSeatsRangeDto().getMaxAmountOfSeats();
        if (!compareValueIfItsInGivenRange(seats, minSeats, maxSeats)) {
            return false;
        }

        var color = car.getColor();
        List<ColorPalette> colors = searchRangeDto.getColors();
        if (!colors.contains(color)) {
            return false;
        }

        var state = car.getState();
        List<State> states = searchRangeDto.getStates();
        if (!states.contains(state)) {
            return false;
        }

        var brand = car.getBrand();
        List<Brand> brands = searchRangeDto.getBrands();
        if (!brands.contains(brand)) {
            return false;
        }

        var petrolType = car.getPetrol();
        List<Petrol> petrolTypes = searchRangeDto.getPetrolTypes();
        if (!petrolTypes.contains(petrolType)) {
            return false;
        }

        var gearboxType = car.getGearbox();
        List<Gearbox> gearboxTypes = searchRangeDto.getGearboxTypes();
        if (!gearboxTypes.contains(gearboxType)) {
            return false;
        }

        var bodyType = car.getBodytype();
        List<Bodytype> bodyTypes = searchRangeDto.getBodytypeList();
        if (!bodyTypes.contains(bodyType)) {
            return false;
        }

        return true;
    }

    private boolean compareValueIfItsInGivenRange(int value, int minValue, int maxValue) {
        return minValue <= value && value <= maxValue;
    }

    @Override
    public boolean hasAtLeastOneNonNullProperty(CarUpdateDto properties) {
        return Stream
                .of(
                        properties.getPrice(),
                        properties.getMileage(),
                        properties.getDisplacement(),
                        properties.getPower(),
                        properties.getDescription(),
                        properties.getYearOfProduction(),
                        properties.getDoorNumber(),
                        properties.getAmountOfSeats(),
                        properties.getVin(),
                        properties.getColor(),
                        properties.getState(),
                        properties.getBrand(),
                        properties.getPetrol(),
                        properties.getGearbox(),
                        properties.getBodytype())
                .filter(Objects::nonNull)
                .count() > 0;
    }
}