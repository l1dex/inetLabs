<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Java Code Geeks Snippets - Sample JSP Page</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</meta>
</head>

<body>
    <%--<c:if session.getAttribute("login") != null>
        req.getRequestDispatcher("content.jsp").forward(req,resp)
    </c:if> !!!!!!!!!!!!!!!!!!!!!!!!!!!!dont work LUL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    --%>
    <form action="/signServlet" method="post">
            <label>Login</label>
            <input type="text" name="login" placeholder="Enter login">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter password">
            <button>Login in</button>
            <p>If you haven't an account - <a href="http://127.0.0.1:8080/regPage.jsp">Registration</a></p>
    </form>
    <%= session.getAttribute("message") %>
</body>
</html>