package com.example.antd.antd_pro.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.example.antd.antd_pro.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {
    @Autowired
    private OSS ossClient;

    @Value("${oss.bucketName}")
    private String bucketName;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + prefix;
        String folder = "头像/";      //指定上传文件夹

        InputStream inputStream = file.getInputStream();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folder + newFileName, inputStream);
        putObjectRequest.setProcess("true");

        PutObjectResult result = ossClient.putObject(putObjectRequest);
        return result.getResponse().getUri();
    }
}
