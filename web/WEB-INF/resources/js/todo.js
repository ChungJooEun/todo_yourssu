// todo list 추가 func
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