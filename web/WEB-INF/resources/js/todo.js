//페이지 로딩시, 모든 todo 로딩
$(document).ready(function () {

    getTodoList();

});

//모든 todo 가져오기
var getTodoList = function () {

    $.ajax({
        url : '/todo/getTodoList',
        async : true,
        type : 'GET',
        contentType : "application/json; charset=UTF-8",
        success : function(data){

            console.log(data);

            if(data == null){
                console.log('no data!');
            }else{
                var datas = data;

                for(let i = 0 ; i < Object.keys(datas).length; i++){
                   addTodoAtList(datas[i]);
                }
            }
        },
        error : function (e) {
            alert("getting Todo List -> error");
        }
    });

};

//todo list에 todo 추가
var addTodoAtList = function (data) {

    var tr = '<tr class = "todo_Comp_tr" name="remove_tr"></tr>';

    if(data.is_done == 'Y'){
        tr += '<td> <input type="checkbox" class = "check_box" value="' + data.id + '" checked onclick="status_todo(this)"' +
            'style = "width : 30px; height : 30px; border:none;"> </td>';

    } else{
        tr += '<td> <input type="checkbox" class = "check_box" value="' + data.id + '" onclick="status_todo(this)"' +
            'style = "width : 30px; height : 30px; border:none;"> </td>';
    }

    tr += '<td><input type = "textbox" value = "' + data.content
        + '" class="input_class"  readonly style="border : none; margin-left:6px;" ' +
        'ondblclick="change_attr(this)" onchange="update_content(this)"' +
        'id = "'+data.id+'"/></td>';

    tr += '<td> <button class = "del_btn" type="button" value="'+data.id+'" onclick="deleteTodo(this.value)"' +
        'style = "width: 40px;\n' +
        '    height: 40px;\n' +
        '    outline:0;\n' +
        '    border:0;\n' +
        '    background-color: white;' +
        'font-size : 30px;' +
        'color:#3f79c1;"> &times; </button> </td>';

    $('#addTodoHere').append(tr);
}

//dbl click -> content 수정 가능하게 arrt 변경
var change_attr = function (obj) {

    obj.removeAttribute("readonly");

}

//값이 변경 되면 함수 실행
var update_content = function (obj) {

    obj.setAttribute("readonly",true);

    if(obj.value != ""){
        var jsonObj = {'id' : obj.getAttribute("id"), 'content' : obj.value};

        $.ajax({
            url : '/todo/updateTodo',
            async: true ,
            type:'PUT',
            contentType : "application/json; charset=UTF-8",
            data : JSON.stringify(jsonObj),
            success : function (data) {

                if(data == 'success'){
                    console.log(data);
                }else{
                    alert("todo status change 실패");
                }

            },
            error : function (e) {
                alert("status change ( done ) todo -> error");
            }
        });
    }else{

        deleteTodo(obj.getAttribute("id"));

    }

}


//check todo -> done
//none check -> not done
var status_todo = function(obj){

    console.log(obj.value);

    var jsonObj = {'id' : obj.value};

    if(obj.checked == true){

        $.ajax({
            url : '/todo/done',
            async: true ,
            type:'PUT',
            contentType : "application/json; charset=UTF-8",
            data : JSON.stringify(jsonObj),
            success : function (data) {

                if(data == 'success'){
                    console.log(data);

                }else{
                    alert("todo status change 실패");
                }

            },
            error : function (e) {
                alert("status change ( done ) todo -> error");
            }
        });

    }else{

        $.ajax({
            url : '/todo/notDone',
            async: true ,
            type:'PUT',
            contentType : "application/json; charset=UTF-8",
            data : JSON.stringify(jsonObj),
            success : function (data) {

                if(data == 'success'){
                    console.log(data);
                }else{
                    alert("todo status change 실패");
                }

            },
            error : function (e) {
                alert("status change ( done ) todo -> error");
            }
        });

    }

};

//todo delete
var deleteTodo = function (del_id) {

    var jsonObj = {'id' : del_id};

    $.ajax({
        url : '/todo/del',
        async: true ,
        type:'PUT',
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify(jsonObj),
        success : function (data) {

            if(data == 'success'){

                $('tbody tr').remove();
                getTodoList();

            }else{
                alert("todo delete 실패");
            }
        },
        error : function (e) {
            alert("delete todo -> error");
        }
    });



}

// 새로운 Todo 입력 받아 추가하기
var addTodo = function () {

    let content = $("#addTodo_textBox").val();

    $.ajax({
        url : '/todo/addTodo',
        async: true ,
        type:'POST',
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify({
            content : content
        }),
        success : function (data) {

            console.log(data);

            if(data == 'success'){

                $("#addTodo_textBox").val('');

                $('tbody tr').remove();
                getTodoList();

            }else{
                alert("todo 추가 실패");
            }

        },
        error : function (e) {
            alert("adding todo -> error");
        }
    });

}