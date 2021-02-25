package com.kuang.controller;


import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String username, HttpServletResponse response) throws IOException {
        if ("kuangshen".equals(username)){
            response.getWriter().println("true");
        }else{
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> users = new ArrayList<>();

        users.add(new User("胡峻皓",18,"男"));
        users.add(new User("胡峻皓",18,"女"));
        users.add(new User("胡峻皓",81,"女"));


        return users;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";

        if (name!=null){
            if ("admin".equals(name)){
                msg="ok";
            }else{
                msg="用户名有误";
            }
        }

        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg="ok";
            }else{
                msg="密码有误";
            }
        }

        return msg;
    }


}
