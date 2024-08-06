package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Imagen;
import com.crudbackend.crud.repository.ImagenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImagenService implements IImagenService{
    private final CloudinaryService cloudinaryService;
    private final ImagenRepository imagenRepository;

    public ImagenService(CloudinaryService cloudinaryService, ImagenRepository imagenRepository) {
        this.cloudinaryService = cloudinaryService;
        this.imagenRepository = imagenRepository;
    }


    @Override
    public Imagen uploadImagen(MultipartFile file) throws IOException {
        Map uploadResult = cloudinaryService.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imageId = (String) uploadResult.get("public_id");
        Imagen image = new Imagen(file.getOriginalFilename(), imageUrl, imageId);
        return imagenRepository.save(image);
    }

    @Override
    public void deleteImagen(Imagen image) throws IOException {
        cloudinaryService.delete(image.getImageId());
        imagenRepository.deleteById(image.getId());
    }
}
