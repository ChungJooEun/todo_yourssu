package com.example.mybatis;

import com.example.model.vo.TodoVO;

import java.util.HashMap;
import java.util.List;

public interface TodoMapper {

    //add todo -> content 받아서 추
    int addTodo(String content);

    //get todoList
    List<TodoVO> getTodoList();

    //todo done
    int close_todo(int id);

    //todo not done
    int open_todo(int id);

    //todo delete
    int del_todo(int id);

    //todo content update
    int updateTodo(HashMap<String, Object> map);
}
