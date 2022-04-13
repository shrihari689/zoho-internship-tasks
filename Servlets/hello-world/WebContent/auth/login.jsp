<!DOCTYPE html>
<html>
<head> 
<title>Login - Zoho Task</title>

</head>
<body>
	
  <h1>Login Page</h1>

  <form method="post">
		 
		 	<p>${successMessage}</p>
		 	<p>${errorMessage}</p>
		 
			<label for="username">Username: </label>	
			<input type="text" name="username" required>
		 
			<label for="password">Password: </label>	
			<input name="password" type="password" minlength="6" required>
		 
			<input type="submit" value="Login">
			
  </form>
  <br>  
  <div>
  	Don't have an account? <a href="/register">Sign up here</a> 
  </div>

  
</body>
</html>