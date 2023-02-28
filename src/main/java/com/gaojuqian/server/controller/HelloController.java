package com.gaojuqian.server.controller;

import com.gaojuqian.server.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Tag(name = "你好他妈的世界")
@RestController
public class HelloController {
    /**
     * 你好他妈的世界
     * @param user
     * @param result
     * @return
     */
    @Operation(summary = "你好世界")
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
        System.out.println(path);
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
