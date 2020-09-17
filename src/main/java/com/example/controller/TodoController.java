package com.example.controller;

import com.example.model.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    //할일 추가
    @RequestMapping(value = "addTodo", method = RequestMethod.POST)
    @ResponseBody
    public String addTodo(@RequestBody Map<String, Object> requestParam){

        String content = (String)requestParam.get("content");

        System.out.println("adding new todo...   " + content);

        boolean res = service.addTodo(content);

        if(res){
            return "success";
        }else{
            return "fail";
        }

    }

    //todo done

    //todo not done

    //todo delete

    //get todoList
}
