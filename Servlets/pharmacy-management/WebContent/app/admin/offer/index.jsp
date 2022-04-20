<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Offers | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>

	<main class="my-5 px-5">
		
		<header>
			<h1 class="font-bold text-xl">Current Offer</h1>
			<p class="text-sm text-gray-600 font-light">Be careful, this is applicable for all the products</p>	
		</header>
		
		<div class="flex flex-col items-center justify-center max-w-4xl px-5 mx-auto">
			
			<c:if test="${currentOffer == null}">
			
				<div class="flex flex-col items-center">
					<img class="h-32" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/facebook/304/wrapped-gift_1f381.png">
					<h2 class="text-xl font-semibold">No Offer is created</h2>
				</div>
	
				<t:button-with-link other="w-48" link="/app/admin/offers/add" value="Add Offer" />
			
			</c:if>
			
			<c:if test="${currentOffer != null}">
				<div class="flex flex-col items-center">
					<img class="h-32" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/facebook/304/wrapped-gift_1f381.png">
					<h2 class="text-2xl text-indigo-800 font-semibold">Offer is activated</h2>
				</div>
			
				<div class="my-2">
					<strong class="font-semibold">Offer Name:</strong> ${currentOffer.name} 				
				</div>
			
				<div class="my-2">
					<strong class="font-semibold">Start Time:</strong> ${currentOffer.getStartTimeString()} 				
				</div>
	
				<div class="my-2">
					<strong class="font-semibold">End Time:</strong>  ${currentOffer.getEndTimeString()}				
				</div>			
	
				<div class="my-2">
					<strong class="font-semibold">Discount:</strong> ${currentOffer.discount} %				
				</div>			
			
				<form action="/app/admin/offers/delete" method="POST">
					<t:button other="w-full bg-red-700 hover:bg-red-800" value="Delete Offer" type="submit" />
				</form>
				
			</c:if>
			
		</div>
		
		
	</main>
	


</t:wrapper>