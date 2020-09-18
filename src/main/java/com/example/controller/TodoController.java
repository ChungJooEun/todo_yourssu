package com.example.controller;

import com.example.model.service.TodoService;
import com.example.model.vo.TodoVO;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

        boolean res = service.addTodo(content);

        if(res){
            return "success";
        }else{
            return "fail";
        }

    }

    //todo done
    @RequestMapping(value="done", method = RequestMethod.PUT)
    @ResponseBody
    public String closeTodo(@RequestBody Map<String, Object> requestParam){

        boolean res;

        String id_get = String.valueOf(requestParam.get("id"));
        int id = Integer.parseInt(id_get);


        if(id < 0 ){
            res = false;
        }else{
            res = service.close_todo(id);
        }

        if(res){
            return "success";
        }else{
            return "fail";
        }

    }

    //todo not done
    @RequestMapping(value="notDone", method = RequestMethod.PUT)
    @ResponseBody
    public String openTodo(@RequestBody Map<String, Object> requestParam){

        boolean res;

        String id_get = String.valueOf(requestParam.get("id"));
        int id = Integer.parseInt(id_get);

        if(id < 0 ){
            res = false;
        }else{
            res = service.open_todo(id);
        }

        if(res){
            return "success";
        }else{
            return "fail";
        }

    }

    //todo delete
    @RequestMapping(value="del", method = RequestMethod.PUT)
    @ResponseBody
    public String delTodo(@RequestBody Map<String, Object> requestParam){

        boolean res;

        String id_get = String.valueOf(requestParam.get("id"));
        int id = Integer.parseInt(id_get);

        if(id < 0 ){
            res = false;
        }else{
            res = service.del_todo(id);
        }

        if(res){
            return "success";
        }else{
            return "fail";
        }

    }

    //get todoList
    @RequestMapping(value = "getTodoList", method = RequestMethod.GET)
    @ResponseBody
    public List<TodoVO> getTodoList(){

        List<TodoVO> list = service.getTodoList();

        return list;

    }

    //update content
    @RequestMapping(value = "updateTodo", method = RequestMethod.PUT)
    @ResponseBody
    public String updateTodo(@RequestBody Map<String, Object> requestParam){

        Boolean res;

        String id_get = String.valueOf(requestParam.get("id"));
        int id = Integer.parseInt(id_get);

        String n_content = (String)requestParam.get("content");

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("n_content",n_content);

        if(id < 0 ){
            res = false;
        }else{

            res = service.updateTodo(map);
        }

        if(res){
            return "success";
        }else{
            return "false";
        }
    }
}
