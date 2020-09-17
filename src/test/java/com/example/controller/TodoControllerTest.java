package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations={
                "file:web/WEB-INF/dispatcher-servlet.xml",
                "file:web/WEB-INF/mybatis-config.xml"
        }
)
public class TodoControllerTest {

    @Autowired
    private TodoController controller;

    @Test
    public void addTodo_test(){

        Object content = "코딩하기";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("content",content);

        String res = controller.addTodo(map);

        System.out.println(res);

    }


}
