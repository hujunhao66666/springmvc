<%--
  Created by IntelliJ IDEA.
  User: 一个帅帅哒男神
  Date: 2021/2/21
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
      function a() {
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"username":$("#username").val()},
          success:function (data) {
            alert(data);
          },
          error:function (data,status) {
            console.log("data="+data);
            console.log("status="+status);
          }
        }
      )
      }
    </script>
  </head>
  <body>
    用户名:<input type="text" id="username" onblur="a()">
  </body>
</html>
