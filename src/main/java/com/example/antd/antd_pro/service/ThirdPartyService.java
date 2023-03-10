package com.example.antd.antd_pro.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ThirdPartyService {
    String uploadImage(MultipartFile file) throws IOException;
}
