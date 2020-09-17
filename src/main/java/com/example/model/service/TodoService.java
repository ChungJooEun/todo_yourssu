package com.example.model.service;

import com.example.model.dao.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoDAO dao;

    //add todo
    public boolean addTodo(String content){

        int res = dao.addTodo(content);

        if(1 == res){
            return true;
        }else{
            return false;
        }

    }


    //todo done

    //todo not done

    //todo delete

    //get todoList
}
