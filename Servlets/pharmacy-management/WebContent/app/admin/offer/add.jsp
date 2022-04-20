<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Manage Offers | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>

	<main class="my-5 px-5">
		
		<header>
			<h1 class="font-bold text-xl">Manage Offer</h1>
			<p class="text-sm text-gray-600 font-light">Be careful, this is applicable for all the products</p>	
		</header>
		
		<t:error-alert heading="Attention needed" />
		
		<form action="/app/admin/offers" class="flex flex-col items-center max-w-xl mx-auto" method="POST">
				
			<t:input type="text" other="required minlength='3'" label="Offer Name" name="name" placeholder="Enter Offer Name" />			
			<t:input type="datetime-local" other="required id='offerStartTime'" label="Offer Start Time" name="offerStartTime" placeholder="Enter Start Date" />			
			<t:input type="datetime-local" other="required id='offerEndTime'" label="Offer End Time" name="offerEndTime" placeholder="Enter End Date" />			
			<t:input type="number" other="required id='discount' max='100' min='0' step='0.1'" label="Discount Percentage" name="discount" placeholder="Discount Percentage" />			
			
			<p id="discountExample"></p>
			
			<t:button other="w-full" type="submit" value="Update Offer" />
			<t:button-with-link link="/app/admin/offers" other="w-full bg-red-700 hover:bg-red-800" value="Cancel" />
			
		</form>		
		
		<script>
			
			function formatDateTime(date = new Date()) {
				date.setMinutes(date.getMinutes() - date.getTimezoneOffset());
				return date.toISOString().slice(0,16);
			}
		
			const offerStartTime = document.getElementById("offerStartTime");
			const offerEndTime = document.getElementById("offerEndTime");
			
			const currentTime = formatDateTime();
			
			offerStartTime.min = currentTime;
			offerStartTime.value = currentTime;
	
			offerEndTime.min = currentTime;
			offerEndTime.value = currentTime;
			
			offerStartTime.addEventListener("change", function (e) {
				const value = e.target.value;
				offerEndTime.min = formatDateTime(new Date(value));
				offerEndTime.value = formatDateTime(new Date(value));
			});
			
		
			const discount = document.getElementById("discount");
			const discountExample = document.getElementById("discountExample");
			
			discount.addEventListener("change", function(e) {
				const value = Number(e.target.value);
				const costPrice = 55;
				const discountedValue = costPrice - (value / 100) * costPrice; 
				discountExample.innerHTML = "<strong class='font-semibold'>Example:</strong> ₹ " + costPrice + " will be sold at ₹ " + discountedValue;
			})
			
		</script>
	
	</main>
	


</t:wrapper>