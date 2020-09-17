package com.example.model.vo;

import lombok.Data;

@Data
public class TodoVO {

    private int id;
    private String content;
    private String is_done;

    public TodoVO(){}

    public TodoVO(int id, String content, String is_done){

        this.id = id;
        this.content = content;
        this.is_done = is_done;

    }

}
