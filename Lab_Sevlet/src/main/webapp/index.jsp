<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<body>

<%
    User user = (User) request.getSession().getAttribute("user");
    if(user != null) {
%>
    <p>Hello, <%= user.getName()%></p>
<%
    }
    else {
%>

    <p>Bạn chưa đăng nhập!</p>
<%
    }
%>
</body>
</html>
