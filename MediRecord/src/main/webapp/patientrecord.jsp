<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediRecord - Record Directory</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-container">
        <img src="logo.png" alt="MediRecord Logo" class="logo">
        <h1>MediRecord</h1>
        
        <nav>
			<a href="index.jsp">Home</a>
			<a href="register">New User</a>
			<a href="login">Login</a>
			<a href="post">Post Record</a>
			<a href="records">Record Directory</a>
		</nav>
		<%
		String message = (String) request.getAttribute("message");
		String healthCard = (String) request.getAttribute("healthCard");
		String firstName = (String) request.getAttribute("firstName");
		String lastName = (String) request.getAttribute("lastName");
		String gender = (String) request.getAttribute("gender");
		String dob = (String) request.getAttribute("dob");	
		String allergies = (String) request.getAttribute("allergies");
		String diagnoses = (String) request.getAttribute("diagnoses");
		%>
				
        <h2>Patient Record</h2>
        <form class="login-form" action='records' method='post'>
            <label for='healthcard'>Health Card #:</label>
            <input type='text' id='healthcard' name='healthcard' maxlength='10' required>
            <button type='submit'>Search Records</button>
        </form>
        
        <p><i><%=message %></i></p>
        
        <%if(healthCard != null) {%>
        <h3>Patient Info</h3>
        <p>Health Card #: <%= healthCard %></p>
        <p>First Name: <%= firstName %></p>
        <p>Last Name: <%= lastName %></p>
        <p>Gender: <%= gender %></p>
        <p>Date of Birth: <%= dob %></p>
        
        <h3>Patient Records</h3>
        <p>Allergies: <%= allergies %></p>
        <h4>Diagnoses</h4>
        <p><%= diagnoses %></p>	
        <%} %>
    </div>
    
    <div class="logout-container">
		<a href="profile">Profile</a>
		<a href="logout">Logout</a>
	</div>
	
</body>
</html>