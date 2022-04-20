<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Pending Returns | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<section class="px-5">
		
		<nav class="flex space-x-8" aria-label="Tabs">
          <!-- Current: "border-indigo-500 text-indigo-600", Default: "border-transparent text-gray-500 hover:text-gray-700 hover:border-gray-300" -->
          <a href="#" class="pointer-events-none cursor-default border-indigo-500 text-indigo-600 whitespace-nowrap py-4 px-1 border-b-2 font-medium text-sm" aria-current="page">
            Pending
          </a>
          <a href="/app/admin/returns/completed" class="border-transparent text-gray-500 hover:text-gray-700 hover:border-gray-300 whitespace-nowrap py-4 px-1 border-b-2 font-medium text-sm">
            Completed
          </a>
          <a href="/app/admin/returns/declined" class="border-transparent text-gray-500 hover:text-gray-700 hover:border-gray-300 whitespace-nowrap py-4 px-1 border-b-2 font-medium text-sm">
            Declined
          </a>
		</nav>
			
		<h2 class="font-bold text-lg my-2">Pending Returns</h2>
	
		<div class="flex flex-col items-center justify-center py-5">
			<c:if test="${orders.size() == 0}">
				<img class="h-16 w-16 mb-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/package_1f4e6.png">
				<p class="text-gray-600">You don't have any pending returns</p>
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
					                		Order No: <strong>${item.code}</strong>
					                	</p>
					                	<p class="text-sm w-full text-gray-600 truncate">
					                		Quantity: <strong>${item.quantity}</strong>
					                	</p>
									</div>
				                	<div class="flex items-center space-x-2">				                	
					                	<form action="/app/admin/returns/complete/${item.id}" method="POST">
					                		<t:button other="bg-green-600 hover:bg-green-800" type="submit" value="Complete" /> 
					                	</form>
					                	<form action="/app/admin/returns/decline/${item.id}" method="POST">
					                		<t:button other="bg-red-600 hover:bg-red-800" type="submit" value="Decline" /> 
					                	</form>
				                	</div>
								</div>	
				            </div>
				        </li>
										
					</c:forEach>
		      	</ul>
			</c:if>
		</div>
		
	
	</section>
		
	
</t:wrapper>
