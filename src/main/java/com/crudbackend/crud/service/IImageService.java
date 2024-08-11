package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {
    Image uploadImagen(MultipartFile file) throws IOException;
    void deleteImagen(Image image) throws IOException;
}
