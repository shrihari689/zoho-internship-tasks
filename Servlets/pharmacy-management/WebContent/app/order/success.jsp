<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Order Successful | Zoho Pharma">
	<%@include file="/shared/navbar.jsp" %>

		<div class="px-4 py-4 sm:px-6">
			<div class="w-full flex items-center justify-between">
				
				<div class="flex flex-col">
					<p class="text-xl w-full font-semibold text-gray-800 truncate">
	                 		${medicine.name}
	               	</p>
	               	<p class="text-sm w-full text-gray-600 truncate">
	               		${medicine.description}
	               	</p>
               	</div>
				
               	<div class="px-2 text-right w-40 space-x-2">
               		<p class="text-2xl font-semibold">₹ ${order.amount}</p>
               		<p class="text-sm text-gray-500">to be paid</p>
               	</div>

			</div>
		</div>
	
		<div class="flex justify-center">
			<img class="h-32" src="https://emojipedia-us.s3.amazonaws.com/source/skype/289/delivery-truck_1f69a.png">
		</div>
		
		<div class="flex justify-center">
			<p>Order ID: <strong>${order.code}</strong></p>			
		</div>
		
		<t:success-alert />
	
		<div class="flex justify-center">		
			<t:button-with-link other="mx-auto" link="/" value="Back to Home" />
		</div>
	

</t:wrapper>