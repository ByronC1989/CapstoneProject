<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediRecord</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1 class="header-title">Welcome to MediRecord</h1>
    </header>
    
    <%@ include file="header.jsp" %>
    
    <%
    if(session.getAttribute("User") != null ) { 
    %>	
		<%@ include file="footer.jsp" %>
	<%} %>
</body>
</html>