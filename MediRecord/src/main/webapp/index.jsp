<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    
    <nav>
        <a href="index.jsp">Home</a>
        <a href="register">New User</a>
        <a href="login">Login</a>
        <a href="post">Post Record</a>
        <a href="records">Record Directory</a>
    </nav>
    
    <%
    if(session.getAttribute("User") != null ) { 
    %>	
    <div class = logout-container>
		<a href="profile">Profile</a>
		<a href="logout">Logout</a>
	</div>
	<%} %>
</body>
</html>