package com.example.model.dao;

import com.example.model.vo.TodoVO;
import com.example.mybatis.TodoMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TodoDAO {

    @Autowired
    private SqlSession sqlSession;

    private TodoMapper getMapper(){
        return sqlSession.getMapper(TodoMapper.class);
    }

    //add todo
    public int addTodo(String content){

        TodoMapper mapper = getMapper();
        int res = mapper.addTodo(content);

        return res;
    }

    //get todoList
    public List<TodoVO> getTodoList() {

        TodoMapper mapper = getMapper();
        List<TodoVO> list = mapper.getTodoList();

        return list;
    }

    //todo done
    public int close_todo(int id){

        TodoMapper mapper = getMapper();
        int res = mapper.close_todo(id);

        return res;
    }

    //todo not done
    public int open_todo(int id){

        TodoMapper mapper = getMapper();
        int res = mapper.open_todo(id);

        return res;
    }

    //todo delete
    public int del_todo(int id){

        TodoMapper mapper = getMapper();
        int res = mapper.del_todo(id);

        return res;
    }

    public int updateTodo(HashMap<String, Object> map) {

        TodoMapper mapper = getMapper();
        int res = mapper.updateTodo(map);

        return res;
    }
}
