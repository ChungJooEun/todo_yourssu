package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

    //할일 추가
    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    @ResponseBody
    public String addTodo(@RequestBody Map<String, Object> requestParam){

        String content = (String)requestParam.get("todo");

        System.out.println("adding Todo ..." + "  " + content);

        boolean res = true;

        if(res){
            System.out.println("add success!");
            return "success";
        }else{
            System.out.println("add fail");
            return "fail";
        }

    }
}
