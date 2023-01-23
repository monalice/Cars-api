package com.carsapi.api.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.carsapi.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
    //Page<Car> findAll(Pageable page);
}
