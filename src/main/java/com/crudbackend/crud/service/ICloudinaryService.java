package com.crudbackend.crud.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

public interface ICloudinaryService {
    Map<String,Object> upload(MultipartFile file) throws IOException;
    Map<String,Object> delete(Long id) throws IOException;

}
