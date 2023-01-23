package com.carsapi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.Car;
import com.carsapi.api.repository.CarRepository;


// gerenciamento das regras de negócio
@Service
public class CarService {
    
    @Autowired
    private CarRepository repository;
    //instancia o repository


    public List<Car> findAll() {
        return repository.findAll();
    }

    public void save(CarDTO req) {
        repository.save(new Car(req));
    }

    public void findById(Long id, CarDTO req) {
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());

            return repository.save(car);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
