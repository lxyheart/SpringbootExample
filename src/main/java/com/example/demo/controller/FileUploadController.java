package com.example.demo.controller;

import com.example.demo.config.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixingyuan on 2018/5/17.
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {
       @RequestMapping("/toUpload")
        public  String toUpload(){
           return "upload";
       }
    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);

        String filePath = request.getServletContext().getRealPath(" src/main/resources/static/img");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
           new Exception("上传出错。。。");
        }
        //返回json
        return "uploadimg success";
    }
}
