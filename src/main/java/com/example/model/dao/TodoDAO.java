package com.example.model.dao;

import com.example.model.vo.TodoVO;
import com.example.mybatis.TodoMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public List<TodoVO> getTodoList() {

        TodoMapper mapper = getMapper();
        List<TodoVO> list = mapper.getTodoList();

        return list;
    }

    //todo done

    //todo not done

    //todo delete

    //get todoList

    //마지막 아이디 조회

}
