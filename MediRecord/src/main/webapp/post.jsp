<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediRecord - New Record</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-container">
        <img src="logo.png" alt="MediRecord Logo" class="logo">
        <h1>MediRecord</h1>
        
        
  	  <%@ include file="header.jsp" %>

        <h2>New Patient Record</h2>
        
		<% String message = (String)request.getAttribute("message"); %>
        <em><%=message %></em><br><br>

        <form class="login-form" action='post' method='post'>
            <label for='healthcard'>Health Card #:</label>
            <input type='text' id='healthcard' name='healthcard' maxlength='10' required><br>

            <label for='firstname'>First name:</label>
            <input type='text' id='firstname' name='firstname' required><br>

            <label for='lastname'>Last name:</label>
            <input type='text' id='lastname' name='lastname' required><br>

            <label for='gender'>Gender:</label>
            <input type='text' id='gender' name='gender' required><br>

            <label for='dateofbirth'>Date of Birth:</label>
            <input type='date' id='dateofbirth' name='dateofbirth' required><br>
            
            <label for='allergies'>Allergies:</label>
            <input type='text' id='allergies' name='allergies' value='None'><br>
            
            <label for='diagnoses'>Diagnoses:</label>
			<textarea id='diagnoses' name='diagnoses' rows='10' cols='50' placeholder='Add patient diagnoses'>
			</textarea>

            <button type='submit'>Submit Patient Record</button>
        </form>

    <%
    if(session.getAttribute("User") != null ) { 
    %>	        	
		<%@ include file="footer.jsp" %>
	<%} %>
    </div>
</body>
</html>