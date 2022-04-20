<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Add Medicine | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	 
	<main class="mx-5 py-10">
		
		<t:error-alert heading="Attention needed" />
		
		<form action="/app/admin/medicines" class="flex flex-col items-center max-w-xl mx-auto" method="POST">
				
			<t:input type="text" other="required minlength='3'" label="Name" name="name" placeholder="Enter Medicine Name" />			
		
			<div class="flex flex-col items-start space-y-2 w-full my-2">
				<label for="description" class="text-gray-700">Description</label>
				<textarea name="description"  required class="ring-2 w-full ring-gray-300 rounded-md outline-none px-2 py-1" placeholder="Enter Description"></textarea>
			</div>
			
			<t:input type="number" other="required min='0' max='1000'" label="Quantity" name="quantity" placeholder="Enter Quantity" />			
			<t:input type="number" other="required min='0' max='10000' step='0.5'" label="Price" name="price" placeholder="Enter Price" />
			
			<t:button other="w-full" type="submit" value="Add Medicine" />
			<t:button-with-link other="w-full bg-red-700 hover:bg-red-800" link="/app" value="Back" />
		
		</form>		
		
	</main>
	
</t:wrapper>



