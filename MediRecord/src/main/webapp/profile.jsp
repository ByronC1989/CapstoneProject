<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	 <div class="login-container">
	    <header>
	        <h1 class="header-title">MediRecord -- Profile</h1>
	    </header>
	    
	    <nav>
	        <a href="index.jsp">Home</a>
	        <a href="register">New User</a>
	        <a href="login">Login</a>
	        <a href="post">Post Record</a>
	        <a href="records">Record Directory</a>
	    </nav>
	    <% 
	    	String username = (String)request.getAttribute("username");
	    	String firstName = (String)request.getAttribute("firstName");
	    	String lastName = (String)request.getAttribute("lastName");
	    	String passMessage = (String)request.getAttribute("passMessage");
	    	String emailMessage = (String)request.getAttribute("emailMessage");
	    	String email = (String)request.getAttribute("email");
	   	%>
	    
	    <h2>Account Info:</h2>
	    <p>Username: <%=username %></p>
	    <p>First Name: <%=firstName %></p>
	    <p>Last Name: <%=lastName %></p>
	    
	    <h2>Change Password</h2>
	    <p><%=passMessage %></p>
	    
	    <form class="login-form" action='profile' method='post'>
			<label for='current-password'>Current Password:</label>
	        <input type='password' id='current-password' name='current-password' placeholder='Enter current password...' required><br>
	       	
	       	<label for='new-password'>New Password:</label>
	        <input type='password' id='new-password' name='new-password' placeholder='Enter new password...' required><br>
	        
	        <input type="hidden" name="function" value="passUpdate">
	        
			<button type='submit'>Change Password</button>
		</form>
			  
	    <h2>Change Email</h2>
	    <p><%=emailMessage %></p>
	    
	    <form class="login-form" action='profile' method='post'>
			<label for='email'>Email:</label>
	        <input type='text' id='email' name='email' placeholder='<%=email %>' required><br>
	               
	        <input type="hidden" name="function" value="emailUpdate">
	        
			<button type='submit'>Change Email</button>
		</form>
    </div>
    
     <div class = logout-container>
		<a href="logout">Logout</a>
	</div>
</body>
</html>