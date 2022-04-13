<%@tag description="Main Wrapper Template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
 
<html>
	<head>
		<title>${title}</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://cdn.tailwindcss.com"></script>
	</head>
	<body>
		<jsp:doBody/>
	</body>
</html>
