package com.carsapi.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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


    public Page<Car> getCars(Pageable pageable) {
        //return repository.findAll(page);

        int page = Integer.parseInt(pageable.getPageParameter());
        int size = Integer.parseInt(pageable.getSizeParameter());
        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size
        );
    }

    public Car findById(Long id) {

        return repository.findById(id)
                .map(user -> user)
                .orElse(null);
    }

    public void save(CarDTO req) {
        repository.save(new Car(req));
    }

    public void update(Long id, CarDTO req) {
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
