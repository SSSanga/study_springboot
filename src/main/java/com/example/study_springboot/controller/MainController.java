package com.example.study_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/main")
public class MainController {
    @Autowired
    
    @GetMapping({"/","/home","/main"})
    public ModelAndView main(ModelAndView modelAndView)
    {
        modelAndView.addObject("Name", "Sanga!!");
        modelAndView.setViewName("/WEB-INF/views/main.jsp");
        return modelAndView ;
    }

}
