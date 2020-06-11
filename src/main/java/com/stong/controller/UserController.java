package com.stong.controller;

import com.stong.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${aaaa}")
    private String aaaa;

    @GetMapping("/get")
    public List<User> get(){
        List<User> users = new ArrayList<>();
        System.out.println("user...");
        users.add(new User(1,"张三",new Date(),20.12d));
        users.add(new User(2,"李四",new Date(1999,10,1),3027d));
        users.add(new User(3,"王五",new Date(30000000111L),1029292d));
        users.add(new User(4,"赵六",new Date(),70d));
        return users;
    }


//    @PostMapping
//    public void save(@RequestBody User user){
//        System.out.println("save..." + user);
//    }


    /**
     * 在纯粹的springMVC中要使用CommonsMultipartFile 在boot中使用MultipartFile接受前端传来的二进制
     * @param photo
     */
    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile photo){

        System.out.println(aaaa);
        try {
            photo.transferTo(new File("/Users/yeon/Desktop/Java/1.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>> >" +photo );
    }
}
