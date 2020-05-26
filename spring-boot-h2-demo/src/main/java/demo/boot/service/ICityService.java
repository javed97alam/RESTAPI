package demo.boot.service;

import java.util.List;

import demo.boot.model.City;

public interface ICityService {

    List<City> findAll();
    City findById(Long id);
}