<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Java Code Geeks Snippets - Sample JSP Page</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</meta>
</head>

<body>
    <% if(session.getAttribute("login") == null) response.sendRedirect("/signPage.jsp"); %>
    <br />
    <form action="/uploadServlet" method="post" name="uploadForm" enctype="multipart/form-data">
    <input name="uploadfile" type="file" >
    <input name="submit" type="submit" value="Submit">
    </form>
    <p><a href="/galleryServlet">Gallery</a></p>
    <form action="/galleryServlet" method="post">
        <input name="delete" type="submit" value="Delete Gallery">
        <input type="text" name="test" placeholder="Test information">
    </form>
</body>
</html>