<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Page</title>
</head>
<body>

 	<form action="/app/add" method="get">
 		First Name: <input type="text" name="first_name" placeholder="First Name">
 		<button>Update</button>
 	</form>
	
	<p>Hey ${user.getFullName()} !</p>	

	<% if(session.getAttribute("note") == null) { %>
	 	<form action="note" method="post">
	 		Word to remember: <input type="text" name="note" placeholder="Write a note">
	 		<input type="submit" name="action" value="Add Note">
	 	</form>	
	<% } else { %>
		<p> You asked me to remember: <%= session.getAttribute("note") %> </p>
		<form action="note" method="post">
			<input type="submit" name="action" value="Delete Note">
		</form>
	<% } %>
 	
 	<br>
 
 	<form action="/auth/logout" method="POST">
 		<input type="hidden" name="_method" value="DELETE">
 		<input type="submit" value="Logout">
 	</form>
 
</body>
</html>