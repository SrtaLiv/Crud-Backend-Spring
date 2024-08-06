package com.crudbackend.crud.service;

import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryService implements ICloudinaryService{
    private final Cloudinary cloudinary;
    @Override
    public Map<String, Object> upload(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public Map<String, Object> delete(Long id) throws IOException {
        return null;
    }
}
