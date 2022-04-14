<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Register | Zoho Pharma">
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="my-5">
		
		<t:error-alert heading="Attention needed" />
		
		<form action="/auth/register" class="flex flex-col items-center max-w-xl mx-auto" method="POST">
				
			<t:input type="text" other="required minlength='3'" label="Full Name" name="name" placeholder="Enter Name" />			
			<t:input type="text" other="required minlength='3'" label="Username" name="username" placeholder="Enter Username" />			
			<t:input type="password" other="required minlength='6'" label="Password" name="password" placeholder="Enter Password" />			
			
			<t:button other="w-full" type="submit" value="Register" />
			
			<p>If you already have an account, <a class="text-blue-800 font-semibold" href="/auth/login">login here</a></p>
			
		</form>		
	
	</main>
	
		
	
</t:wrapper>



