<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录成功</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/base.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/ext-all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/ext-lang-zh_CN.js"></script>
    <link  href="${pageContext.request.contextPath}/util/css/ext-theme-classic-all.css" rel="stylesheet"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#showData").click(function () {
                Ext.MessageBox.alert('title','message');
               $.post({
                   url:'/controller/student/data/list',
                   data:{},
                   dataType:"json",
                   success:function (str) {
                       $("#divDate").append("<tr><td>id</td><td>name</td><td>pwd</td><td>sex</td></tr>");
                      var array = typeof(str)=='string'?JSON.parse(str):str;
                       for(var i=0;i<array.length;i++){
                           $("#divDate").append("<tr><td>"+array[i].id+"</td><td>"+array[i].name+"</td><td>"+array[i].pwd+"</td><td>"+array[i].sex+"</td></tr>")
                       }
                   }
               });
            });

            //清除元素下边的HTML
            $("#clearData").click(function () {
                $("#divDate").html("")
            })
        })
    </script>
</head>
<body>
Drag 和 Drop 是一种直接操作动作，在许多图形用户界面系统中都会遇到它，<br>
它提供了一种机制，能够在两个与 GUI 中显示元素逻辑相关的实体之间传输信息。<br>
<input  id="showData"type="button" value="显示数据"/>
<input  id="clearData"type="button" value="清除数据"/>
<div id="divDate">

</div>
</body>
</html>
