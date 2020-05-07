<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Java Code Geeks Snippets - Sample JSP Page</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</meta>
</head>

<body>
    <form action="/regServlet" method="post">
            <label>Login</label>
            <input type="text" name="login" placeholder="Enter login">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter password">
            <button>Registration</button>
            <p>Already have an account? - <a href="http://127.0.0.1:8080/signPage.jsp">Sign in</a></p>
    </form>
    <%= session.getAttribute("message") %>
</body>
</html>