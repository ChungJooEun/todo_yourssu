package com.example.model.service;

import com.example.model.dao.TodoDAO;
import com.example.model.vo.TodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //get todoList
    public List<TodoVO> getTodoList() {

        List<TodoVO> list = dao.getTodoList();

        if(list == null){
            System.out.println("Todo List is NULL");

        }

        return list;
    }


    //todo done

    //todo not done

    //todo delete


}
