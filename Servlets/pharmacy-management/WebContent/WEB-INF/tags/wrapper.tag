<%@tag description="Main Wrapper Template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>
	<head>
		<title>${title}</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="https://cdn.tailwindcss.com"></script>
		<link rel="icon" href="/shared/favicon.ico">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;600;700;800;900&display=swap" rel="stylesheet">
		<style>
			body {
				font-family: 'Nunito', sans-serif;
			}
			
			/* width */
			::-webkit-scrollbar {
			  width: 6px;
			}
			
			/* Track */
			::-webkit-scrollbar-track {
			  box-shadow: inset 0 0 2px #888888;
			  border-radius: 10px;
			}
			
			/* Handle */
			::-webkit-scrollbar-thumb {
			  background: #aaaaaa;
			  border-radius: 10px;
			}
			
			/* Handle on hover */
			::-webkit-scrollbar-thumb:hover {
			  background: #888888;
			}
		</style>
		<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	</head>
	
	<body class="bg-gray-50">
		<jsp:doBody/>
	</body>
</html>
