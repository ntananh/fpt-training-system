<%-- 
    Document   : logout
    Created on : Aug 27, 2021, 3:39:00 PM
    Author     : Tan Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logged out</title>
    </head>
    <body>
        <%
            session.removeAttribute("username");
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
