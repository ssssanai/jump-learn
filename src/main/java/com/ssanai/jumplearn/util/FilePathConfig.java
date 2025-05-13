package com.ssanai.jumplearn.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Log4j2
@Configuration
@PropertySource("classpath:application.properties")
public class FilePathConfig {

    @Value("${upload.path}")
    private String uploadPath;

    public String getUploadPath() {
        log.info(uploadPath);
        return uploadPath;
    }
}