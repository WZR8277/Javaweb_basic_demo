<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    int i = 5;

    String contextPath = request.getContextPath();
    out.print(contextPath);
%>

<%!
    int i = 3;
%>
<%= "hello" %>

<h1>hi~ jsp!</h1>

<% response.getWriter().write("response....."); %>
</body>
</html>