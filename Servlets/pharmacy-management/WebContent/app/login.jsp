<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Login | Zoho Pharma">
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="my-5">
		
		<t:error-alert heading="Attention needed" />
		
		<form action="/auth/login" class="flex flex-col items-center max-w-xl mx-auto" method="POST">
				
			<t:input type="text" other="required minlength='3'" label="Username" name="username" placeholder="Enter Username" />			
			<t:input type="password" other="required minlength='6'" label="Password" name="password" placeholder="Enter Password" />			
			
			<t:button type="submit" value="Login" />
			
			<p class="my-2">If you don't have an account, <a class="text-blue-800 font-semibold" href="/auth/register">register here</a></p>
			
		</form>		
	
	</main>
	
		
	
</t:wrapper>



