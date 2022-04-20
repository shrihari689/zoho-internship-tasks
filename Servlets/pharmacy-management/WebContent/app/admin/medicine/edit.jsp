<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Add Medicine | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>

	<main class="mx-5 py-5">
		
		<t:error-alert heading="Attention needed" />
		
		<form action="/app/admin/medicines/update" class="flex flex-col items-center max-w-xl mx-auto" method="POST">
				
				
			<input type="hidden" value="${medicine.id}" name="id">
				
			<t:input value="${medicine.name}" type="text" other="required minlength='3'" label="Name" name="name" placeholder="Enter Medicine Name" />			
		
			<div class="flex flex-col items-start space-y-2 w-full my-2">
				<label for="description" class="text-gray-700">Description</label>
				<textarea name="description"  required class="ring-2 w-full ring-gray-300 rounded-md outline-none px-2 py-1" placeholder="Enter Description">${medicine.description}</textarea>
			</div>
			
			<t:input value="${medicine.quantity}" type="number" other="required min='0' max='1000'" label="Quantity" name="quantity" placeholder="Enter Quantity" />			
			<t:input value="${medicine.price}" type="number" other="required min='0' max='10000' step='0.5'" label="Price" name="price" placeholder="Enter Price" />
			
			<t:button other="w-full" type="submit" value="Update Medicine" />
			<t:button-with-link other="w-full bg-red-700 hover:bg-red-800" link="/app/admin/medicines" value="Back" />
		
		</form>		
		
	</main>
	
</t:wrapper>



