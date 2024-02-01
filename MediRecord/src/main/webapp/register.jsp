<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediRecord - Register User</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-container">
        <img src="logo.png" alt="MediRecord Logo" class="logo">
        <h1>MediRecord</h1>
        
  	  <%@ include file="header.jsp" %>

        <h2>User Registration</h2>
		<% String message = (String)request.getAttribute("message"); %>
        <em><%=message %></em><br><br>

        <form class="login-form" action='register' method='post'>
            <label for='username'>Username:</label>
            <input type='text' id='username' name='username'><br>

            <label for='firstname'>First name:</label>
            <input type='text' id='firstname' name='firstname'><br>

            <label for='lastname'>Last name:</label>
            <input type='text' id='lastname' name='lastname'><br>

            <label for='email'>Email:</label>
            <input type='text' id='email' name='email'><br>

            <label for='password'>Password:</label>
            <input type='password' id='password' name='password'><br>

            <!-- hidden value sets user to unverified by default -->
            <input type='hidden' id='verifieduser' name='verifieduser' value='0'><br>

            <button type='submit'>Register User!</button>
        </form>

    <%
    if(session.getAttribute("User") != null ) { 
    %>	       
		<%@ include file="footer.jsp" %>
	<%} %>		
    </div>
</body>
</html>