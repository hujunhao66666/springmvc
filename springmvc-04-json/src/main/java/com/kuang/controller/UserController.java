package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController //添加了这个，其下的所有代码都返回字符串，不走视图解析器
public class UserController {

    @RequestMapping(value = "/j1")
    //@ResponseBody //添加了这个就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("胡峻皓", 18, "男");
        User user1 = new User("胡峻皓1", 18, "男");
        User user2 = new User("胡峻皓2", 18, "男");
        User user3 = new User("胡峻皓3", 18, "男");
        User user4 = new User("胡峻皓4", 18, "男");

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String s = objectMapper.writeValueAsString(users);
        return s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        return objectMapper.writeValueAsString(simpleDateFormat.format(date));
    }

    @RequestMapping("/j3")
    public String json3(){
        User user = new User("胡峻皓", 18, "男");
        User user1 = new User("胡峻皓", 22, "男");
        User user2 = new User("胡峻皓", 21, "男");
        User user3 = new User("胡峻皓", 20, "男");
        User user4 = new User("胡峻皓", 19, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String s = JSON.toJSONString(userList);
        return s;
    }
}
