package com.kuang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest {


    @RequestMapping("/m1")
    public String test1(Model model){
        model.addAttribute("msg","hello again");
        return "redirect:index.jsp";
    }
}
