package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService service;
    //instancia o service

    @GetMapping
    public List<Car> listAll() {
        return service.findAll();
    }
    @PostMapping
    public void create(@RequestBody CarDTO req) {
        service.save(req);
    }

    @PutMapping("/{id}")
    public void putCar(@PathVariable Long id, @RequestBody CarDTO req) {
        service.findById(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        service.deleteById(id);
    }
}