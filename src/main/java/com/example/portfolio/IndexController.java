package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showhome(){
        return "index";
    }
    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }
    @GetMapping("/werk")
    public String showWerk(){
        return "werk";
    }
    @GetMapping("/studie")
    public String showStudie() {return "studie";}
    @GetMapping("/skills")
    public String showSkills() {return "skills";}

}