package com.example.antd.antd_pro.controller;


import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.service.ThirdPartyService;
import com.example.antd.antd_pro.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("api/third")
public class ThirdPartyController {
    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping("/oss/upload")
    public R uploadImg(@RequestParam("avatar") MultipartFile file) {
        try {
            String url = thirdPartyService.uploadImage(file);
            log.info(url);
            return R.ok().put("imageUrl", url);
        } catch (IOException e) {
            return R.error(ErrorEnum.IMAGE_UPLOAD_FAILED.getCode(), ErrorEnum.IMAGE_UPLOAD_FAILED.getMessage());
        }
    }
}
