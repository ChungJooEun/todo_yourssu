package com.example.mybatis;

import com.example.model.vo.TodoVO;

import java.util.List;

public interface TodoMapper {

    //add todo -> content 받아서 추
    int addTodo(String content);

    //get todoList
    List<TodoVO> getTodoList();

    //todo done

    //todo not done

    //todo delete

}
