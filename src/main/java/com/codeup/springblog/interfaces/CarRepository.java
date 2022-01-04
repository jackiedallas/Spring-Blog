package com.codeup.springblog.interfaces;

import com.codeup.springblog.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMake(String make);
    List<Car> findAllByMake (String make);
}
