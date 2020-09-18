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

    var tr = '<tr class = "todo_Comp_tr" name="todoTB_tr" onmouseover="showBtn(this)" onmousedown="hideBtn(this)"></tr>';

    if(data.is_done == 'Y'){
        tr += '<td> <input type="checkbox" name="is_done" value="' + data.id + '" checked> </td>';
    } else{
        tr += '<td> <input type="checkbox" name="is_done" value="' + data.id + '"> </td>';
    }

    tr += '<td>"' + data.content + '"</td>';
    tr += '<td> <button type="button" value="'+data.id+'" onclick="deleteTodo(this.value)"> &times; </button> </td>';

    $('#addTodoHere').append(tr);
}

// tr에 마우스 오버했을때, 버튼 보이게 하기
var showBtn = function (obj) {
    obj.find("input").css("display","block");
};

var hideBtn = function(obj){
    obj.find("input").css("display","none");
};


//todo delete
var deleteTodo = function (clicked_id) {

    console.log(clicked_id);

}

// 새로운 Todo 입력 받아 추가하기
var addTodo = function () {

    let content = $("#addTodo_textBox").val();

    console.log(content);

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