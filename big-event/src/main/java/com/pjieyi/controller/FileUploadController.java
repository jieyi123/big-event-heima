package com.pjieyi.controller;

import com.pjieyi.pojo.Result;
import com.pjieyi.utils.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author pjieyi
 * @Description 文件上传
 */
@RestController
public class FileUploadController {

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        //获取原始文件名
        String filename=file.getOriginalFilename();
        filename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
        String url=aliyunOssUtil.upload(filename,file.getInputStream());
        //file.transferTo(new File("C:\\Users\\pjy17\\Desktop\\img\\"+filename));
        return Result.success(url);
    }
}
