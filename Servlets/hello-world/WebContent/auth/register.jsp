<!DOCTYPE html>
<html>
<head> 
<title>Login - Zoho Task</title>

</head>
<body>
	
  <h1>Register Page</h1>

  <form method="post">
		 
		 	<p>${successMessage}</p>
		 	<p>${errorMessage}</p>
		 
		 	<label for="fullname">Full Name: </label>	
			<input type="text" name="fullname" required>
			
			<br><br>
			 
			<label for="username">Username: </label>	
			<input type="text" name="username" required>
		 
		 	<br><br>
		 
			<label for="password">Password: </label>	
			<input name="password" type="password" minlength="6" required>
		 
			<br><br>
		
			<input type="submit" value="Login">
			
  </form>
  <br>  
  <div>
  	Already have an account? <a href="/login">Login here</a> 
  </div>

  
</body>
</html>