package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*") //correção de erro Corss
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarService service;
    //instancia o service

    @GetMapping
    public List<Car> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping
    public void create(@RequestBody CarDTO req) {
        service.save(req);
    }

    @PutMapping("/{id}")
    public void putCar(@PathVariable Long id, @RequestBody CarDTO req) {
        service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        service.deleteById(id);
    }
}