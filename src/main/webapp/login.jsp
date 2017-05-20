<%@ page pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head >
    <%--为何不行呢--%>
<%--<script type="text/javascript" src="util/jquery-3.2.1.js"/>--%>
<script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#loginBtnGet").click(function () {
        //方式1拼接url值
//        $.get('/myWeb/jsp/login_get?id=10001&pwd="pwd10001"')

        //方式2传递json
//         $.get('/myWeb/jsp/login_get',{id:1001,pwd:"pwd1001"})

        //第三种传递数据的方式。注意要计算值。!!!!!!!!!!!用val(),这个地方错了许多次了
//         $.get('/myWeb/jsp/login_get',{"id":$("#id").val(),"pwd":$("#pwd").val()})

//       第四种方式
            $.get({
                url:'/myWeb/jsp/login_get',
                data:{"id":$("#id").val(),"pwd":$("#pwd").val()}
            })
    });

    $("#loginBtnPost").click(function () {
//        字段接收
//        $.post({
//            url:'/myWeb/jsp/login_post',
//            data:{"id":$("#id").val(),"pwd":$("#pwd").val()}
//        });

//        对象接收
        $.post({
            url:'/myWeb/jsp/login_post_obj',
            data:{"id":$("#id").val(),"pwd":$("#pwd").val(),"courseList":[]}
        });
    });

    $("#loginBtnAjaxPost").click(function () {
        $.ajax({
            url:'/myWeb/jsp/login_ajax_post_obj',
            async:true,
            data:{"id":$("#id").val(),"pwd":$("#pwd").val(),"courseList":[]},
            dataType:"json",
            method:"POST",
            success:function (str) {
                if(str.code=='success') {
                    window.location.href='/myWeb/jsp/student.jsp';
                }else if(str.code=='error') {
                    alert(str.msg);
                }
            }
        })
    });
})
</script>
</head>
<body>
<form>
    用户名:<input id="id" type="text"/><br>
    密 码:<input id="pwd"  type="password"/><br>
    <input id="loginBtnAjaxPost" type="button" value="登陆$Ajax"/>
    <input id="loginBtnPost" type="button" value="登陆$post"/>
    <input id="loginBtnGet" type="button" value="登陆$get"/>
</form>
</body>
</html>
