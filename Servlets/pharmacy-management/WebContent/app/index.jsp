<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Home | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<header class="max-w-4xl mx-auto pt-10 pb-5">
	
		<form action="/search" class="w-full bg-white rounded-md flex items-center b-1 border-gray-400 shadow-md">
		    <input type="search" required name="query" class="w-full bg-white text-black h-full rounded-md p-5 pl-6 outline-none" placeholder="Search for medicines..">
		    <button type="submit" class="h-10 w-10 rounded-md bg-indigo-600 mr-5 flex justify-center items-center text-white">
		      <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
		        <path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd" />
		      </svg>
		    </button>
		</form>

	</header>
	
	<section class="px-5 py-10">
			
		<h2 class="font-bold text-lg">Your Recent Orders</h2>
	
		<div class="flex flex-col items-center justify-center py-5">
			<c:if test="${orders.size() == 0}">
				<img class="h-16 w-16 mb-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/pill_1f48a.png">
				<p class="text-gray-600">You haven't ordered anything!</p>
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
				                	<p class="text-sm w-full text-gray-600 truncate">
				                		Quantity: <strong>${item.quantity}</strong>
				                	</p>
				                	<t:button-with-link other="w-28" link="/order/details/${item.code}" value="${item.code}" /> 
								</div>	
				            </div>
				        </li>
										
					</c:forEach>
		      	</ul>
			</c:if>
		</div>
		
	
	</section>
		
	
</t:wrapper>



