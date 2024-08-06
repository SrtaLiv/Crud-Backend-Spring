package com.crudbackend.crud.service;

import com.crudbackend.crud.model.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImagenService {
    Imagen uploadImagen(MultipartFile file) throws IOException;
    void deleteImagen(Imagen image) throws IOException;
}
