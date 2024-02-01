<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediRecord - Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-container">
    <img src="logo.png" alt ="Logo" class = "logo">
        <h1>MediRecord</h1>
        
        <nav>
			<a href="index.jsp">Home</a>
			<a href="register">New User</a>
			<a href="login">Login</a>
			<a href="post">Post Record</a>
			<a href="records">Record Directory</a>
		</nav>

        <h2>User Login</h2>
		<% String message = (String)request.getAttribute("message"); %>
        <em><%=message %></em><br><br>

        <form class="login-form" action='login' method='post'>
            <label for='username'>Username:</label>
            <input type='text' id='username' name='username'><br>

            <label for='password'>Password:</label>
            <input type='password' id='password' name='password'><br>

            <button type='submit'>Login!</button>
        </form>
        
          <div class = "logout-container">
			<a href="profile">Profile</a>
			<a href="logout">Logout</a>
		</div>
    </div>
</body>
</html>