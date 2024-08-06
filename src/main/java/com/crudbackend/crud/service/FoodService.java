package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Food;
import com.crudbackend.crud.model.Imagen;
import com.crudbackend.crud.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FoodService implements IFoodService{
    //@Autowired
    //FoodRepository repository;

    // MEJOR FORMA DE HACERLA:
    private final FoodRepository foodRepository;
    private final ImagenService imagenService;

    public FoodService(FoodRepository foodRepository, ImagenService imagenService) {
        this.foodRepository = foodRepository;
        this.imagenService = imagenService;
    }


    //Cambio de metodos para incluir archivos
    @Override
    public Food save(Food food, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            Imagen img = imagenService.uploadImagen(file);
            food.setImage(img);
        }
        return foodRepository.save(food);
    }

    @Override
    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foodRepository.findAll());
    }

    @Override
    public Optional<Food> getById(Long id) {
        return foodRepository.findById(id);
    }

    @Override //Borra imagen y libro
    public void delete(Food food) throws IOException {
        if (food.getImage()!=null){
            imagenService.deleteImagen(food.getImage());
        }
        foodRepository.deleteById(food.getId());
    }

    @Override
    public Food updateFood(Food food){
        return foodRepository.save(food);
    }

    @Override
    public Food updateFoodImage(Food food, MultipartFile file) throws IOException {
        if (food.getImage() != null){
            imagenService.deleteImagen(food.getImage());
        }
        Imagen newImg = imagenService.uploadImagen(file);
        food.setImage(newImg);
        return foodRepository.save(food);
    }
}
