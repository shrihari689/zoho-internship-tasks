<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Returns | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="p-5 mx-5">
	
		<header>
			<h1 class="font-bold text-xl">Requested Returns</h1>
			<p class="text-sm text-gray-600 font-light">It may take upto 2 hours to review your order returns</p>	
		</header>
	
		<section class="my-5">
			<h2 class="font-semibold">Order Returns</h2>
			
			<div class="flex flex-col items-center justify-center py-5">
				<c:if test="${orders.size() == 0}">
					<img class="h-16 w-16 mb-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/pill_1f48a.png">
					<p class="text-gray-600">No orders were requested for return!</p>
				</c:if>
				
				<c:if test="${orders.size() > 0}">
					<ul class="divide-y w-full divide-gray-200 space-y-3">
						<c:forEach var="item" items="${orders}">				
							<li class="w-full bg-white">
								<div class="px-4 py-4 sm:px-6">
									<div class="w-full flex items-center justify-between">
										<p class="text-xl w-full font-semibold text-gray-800 truncate">
					                  		${item.medicineName}
					                	</p>
					                	<div class="px-2 text-right w-36 space-x-2">
					                		<p class="text-xl font-semibold">₹ ${item.amount}</p>
					                	</div>
					                </div>
					                 <div class="flex items-center justify-between">
					                	<div>
						                	<p class="text-sm w-full text-gray-600 truncate">
						                		Order ID: <strong>${item.code}</strong>
						                	</p>				                	
						                	<p class="text-sm w-full text-gray-600 truncate">
						                		Quantity: <strong>${item.quantity}</strong>
						                	</p>
					                	</div>
				                		<t:button-with-link link="" other="bg-gray-700 hover:bg-gray-800 pointer-events-none cursor-default" value="${item.status.toString()}" /> 
									</div>	
					            </div>
					        </li>
											
						</c:forEach>
			      	</ul>
				</c:if>
			</div>	
			
		</section>
	
	</main>
	
</t:wrapper>



