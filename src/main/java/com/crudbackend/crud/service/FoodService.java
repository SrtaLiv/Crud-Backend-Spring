package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Food;
import com.crudbackend.crud.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FoodService implements IFoodService{
    @Autowired
    FoodRepository repository;
    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public ArrayList<Food> getFoods() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Optional<Food> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Food food) {
        repository.delete(food);
    }

    @Override
    public Food update(Food food){
        return repository.save(food);
    }
}
