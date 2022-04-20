<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Home - Reports | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	 
	<main class="grid grid-cols-3 mx-5 py-10">
		<div class="grid grid-cols-3 col-span-2 gap-2 select-none">
			<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Today's Orders
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	${todayCount}
        	  	  </dd>
         	 	</div>
       		</div>
     		<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Pending Orders
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	${pendingCount}
        	  	  </dd>
         	 	</div>
       		</div>
     		<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Today's Returns
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	${todayReturnCount}
        	  	  </dd>
         	 	</div>
       		</div>
       		<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Out of Stock
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	${outOfStockCount}
        	  	  </dd>
         	 	</div>
       		</div>
       		<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Today's Revenue
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	₹ ${todayRevenue}
        	  	  </dd>
         	 	</div>
       		</div>
       		<div class="bg-white hover:bg-gray-100 overflow-hidden shadow-md rounded-lg">
         		<div class="px-4 py-5 sm:p-6">
        	 	   <dt class="text-sm font-medium text-gray-500 truncate">
        	 	     Pending Reports
       		 	   </dt>
        	  	  <dd class="mt-1 text-3xl font-semibold text-gray-900">
        	  	  	0
        	  	  </dd>
         	 	</div>
       		</div>
		</div>
		<div class="flex flex-col items-center">	
			<t:button-with-link link="/app/admin/medicines/new" value="Add Medicine" />
			<t:button-with-link link="/app/admin/offers" value="View Offers" />
			<t:button-with-link link="/app/admin/orders" value="View Orders" />
			<t:button-with-link link="/app/admin/returns" value="View Returns" />
			<t:button-with-link link="/app/admin/medicines" value="View Medicines" />
		</div>
	</main>
	
</t:wrapper>



