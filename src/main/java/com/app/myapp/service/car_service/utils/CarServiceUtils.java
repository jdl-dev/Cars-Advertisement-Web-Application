package com.app.myapp.service.car_service.utils;

import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import com.app.myapp.model.model.Car;

public interface CarServiceUtils {
    Car updatingCarWithNewDataFromUser(Car carToBeUpdated, CarUpdateDto carWithUpdatingData);

    boolean filterCarsForUserWithGivenSearchRangeBounds(Car car, SearchRangeDto searchRangeDto);

    boolean hasAtLeastOneNonNullProperty(CarUpdateDto carWtihDataToUpdateCarInDatabase);

    default boolean isDateOfUpdatingTheAddValid(CarUpdateDto carWtihDataToUpdateCarInDatabase) {
        return carWtihDataToUpdateCarInDatabase.getDateOfUpdatingTheAdd() != null;
    }
}
