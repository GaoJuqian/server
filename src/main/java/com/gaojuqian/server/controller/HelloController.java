package com.gaojuqian.server.controller;

import com.gaojuqian.server.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    /**
     * 你好他妈的世界
     * @param user
     * @param result
     * @return
     */
    @PostMapping("/hello")
    public Object hello(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                return error.getDefaultMessage();
            }
        }
        return user;
    }

    /**
     * 上传文件
     * @param file 文件
     * @param request getRealPath
     * @return 上传成功
     */
    @PostMapping("/uploadFile")
    public Object uploadFile(MultipartFile file, HttpServletRequest request) {

        String path = request.getServletContext().getRealPath("/upload/");
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();

        String fileName = file.getOriginalFilename();
        File saveFile = new File(dir, fileName);
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "上传成功";
    }


}
