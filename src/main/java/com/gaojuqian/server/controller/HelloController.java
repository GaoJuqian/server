package com.gaojuqian.server.controller;

import com.gaojuqian.server.entity.User;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @PostMapping("/hello")
    public Object hello(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError error : errorList){
                return error.getDefaultMessage();
            }
        }
        return user;
    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public RtnResult handValidException(MethodArgumentNotValidException e){
//        BindingResult bindingResult = e.getBindingResult();
//        Map<String, Object> map = new HashMap<>();
//        bindingResult.getFieldErrors().forEach(fieldError -> {
//            map.put(fieldError.getField(),fieldError.getDefaultMessage());
//        });
//        return RtnResult.fail(map);
//    }

}
