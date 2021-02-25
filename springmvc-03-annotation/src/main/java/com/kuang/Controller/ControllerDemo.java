package com.kuang.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c")
public class ControllerDemo {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","你又成功了");
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model){
        model.addAttribute("msg","test2");
        return "hello";
    }

    @RequestMapping("/hello3")
    public String hello3(int a,int b,Model model){
        int res=a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }

    @RequestMapping("/hello4/{a}/{b}")
    public String hello4(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }

    @GetMapping("/hello5/{a}/{b}")
    public String hello5(@PathVariable int a,@PathVariable int b,Model model){
        int res=a+b;
        model.addAttribute("msg","结果2为"+res);
        return "hello";
    }

    @PostMapping("/hello5/{a}/{b}")
    public String hello6(@PathVariable int a,@PathVariable int b,Model model){
        int res=a+b;
        model.addAttribute("msg","postmapping结果为"+res);
        return "hello";
    }


}
