package com.haijiao.project.client;

import com.haijiao.project.config.FeignMultipartSupportConfig;
import com.haijiao.project.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "service-file",configuration = FeignMultipartSupportConfig.class)
@Component
public interface FileClient {

    @PostMapping(value="/files/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE ) //, consumes = MediaType.MULTIPART_FORM_DATA_VALUE
//    @PostMapping("/files/upload")
    String upload( @RequestPart(value = "file") MultipartFile file);

}
