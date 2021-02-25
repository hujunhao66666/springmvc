package com.kuang.Controller;


import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        System.out.println("收到的前端参数为："+name);
        model.addAttribute("msg",name);
        return "hello";
    }

    @RequestMapping("/t2")
    public String test2(User user){
        System.out.println(user);

        return "hello";
    }
}
