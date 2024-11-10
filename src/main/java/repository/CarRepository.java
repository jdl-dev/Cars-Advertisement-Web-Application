package repository;

import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> getAllCars();

    List<Car> getAllCarsByBrandAndPriceIsLessThanEqualAndYearOfProductionIsLessThanEqualAndBodytypeAndPetrol(); //first page otomoto example

    List<Car> saveAllCars(List<Car> cars);
}
