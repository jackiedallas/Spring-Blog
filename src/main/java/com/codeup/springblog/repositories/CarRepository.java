package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByMake(String make);
    List<Car> findAllByMake (String make);
}
