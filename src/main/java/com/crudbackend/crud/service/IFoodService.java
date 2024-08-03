package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Food;

import java.util.ArrayList;
import java.util.Optional;

public interface IFoodService {
    Food save(Food food);
    ArrayList<Food> getFoods();
    Optional<Food> getById(Long id);
    void delete(Food food);
    Food update(Food food);

}
