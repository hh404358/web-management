package com.hahaha.webmanagement.controller;

import com.aliyun.oss.AliOSSUtils;
import com.hahaha.webmanagement.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        log.info("上传文件：url:{}",url);
        return Result.success(url);
    }
}
