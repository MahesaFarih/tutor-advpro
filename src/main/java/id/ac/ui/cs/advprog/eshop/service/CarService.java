package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import java.util.List;

public interface CarService {
    Car create(Car car);
    List<Car> findAll();
    Car findById(String carId);
    Car update(String carId, Car car);  // Changed to return Car
    void delete(String carId);          // Renamed from deleteCarById
}