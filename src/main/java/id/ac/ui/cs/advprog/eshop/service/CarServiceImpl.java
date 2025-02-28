package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.create(car); // Directly return the repository's result
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll(); // No more Iterator conversion
    }

    @Override
    public Car findById(String carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car update(String carId, Car car) {
        return carRepository.update(carId, car); // Now returns the updated car
    }

    @Override
    public void delete(String carId) {
        carRepository.delete(carId);
    }
}