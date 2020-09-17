// todo list 추가 func
var addTodo = function () {

    let todo = $("#addTodo_textBox").val();

    console.log(todo);

    $.ajax({
        url : '/todo/addTodo',
        async: true ,
        type:'POST',
        contentType : "application/json; charset=UTF-8",
        data : JSON.stringify({
            todo : todo
        }),
        success : function (data) {

            console.log(data);

            if(data == 'success'){
                alert("todo 추가 성공");
            }else{
                alert("todo 추가 실패");
            }

        },
        error : function (e) {
            alert("error!");
        }
    });

}