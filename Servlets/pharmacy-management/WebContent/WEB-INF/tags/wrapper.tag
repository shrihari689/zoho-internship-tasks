<%@tag description="Main Wrapper Template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>

<html>
	<head>
		<title>${title}</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://cdn.tailwindcss.com"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;600;700;800;900&display=swap" rel="stylesheet">
		<style>
			body {
				font-family: 'Nunito', sans-serif;
			}
		</style>
		<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	</head>
	
	<body class="bg-gray-50">
		<jsp:doBody/>
	</body>
</html>
