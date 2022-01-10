package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    private final CarRepository carDao;

    public CarController(CarRepository carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String carIndex(Model model) {
        model.addAttribute("cars", carDao.findAll());

        model.addAttribute("chevy", carDao.findAllByMake("Chevrolet"));
        model.addAttribute("honda", carDao.findAllByMake("Honda"));
        return "cars";
    }

}
