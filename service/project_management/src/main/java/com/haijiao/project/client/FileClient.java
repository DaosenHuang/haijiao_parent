package com.haijiao.project.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("service-file")
@Component
public interface FileClient {

    @PostMapping("/files/upload")
    String upload(@RequestParam(value = "file") MultipartFile file);

}
