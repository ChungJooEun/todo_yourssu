package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String gotoMain(){

        return "todoList";
    }

}
