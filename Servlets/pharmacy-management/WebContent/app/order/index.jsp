<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Place Order | Zoho Pharma">
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="my-5">
		
		<t:error-alert heading="Attention needed" />
		
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
               		<p class="text-2xl font-semibold">₹ ${medicine.price}</p>
               		<p class="text-sm text-gray-500">per item</p>
               	</div>

			</div>
		</div>
	
		
		
		<form class="flex flex-col w-full max-w-4xl mx-auto items-center" method="post" action="/order/${medicine.id}">
		
			<t:input value="1" other="id='medicine-quantity' min='0' max='${medicine.quantity}'" label="Quantity" name="quantity" type="number" placeholder="Enter Quantity"></t:input>
			<div class="mr-auto text-sm font-light mb-2">Available: ${medicine.quantity}</div>

			<div class="my-2 space-x-2 flex items-center w-full">
             	<span>Net Amount: </span>
             	<c:if test="${currentOffer != null}">
             			<p id="old-medicine-price" class="text-sm line-through font-semibold line-through text-gray-600">₹ ${medicine.price}</p>			                		
             			<p id="medicine-price" class="text-xl font-semibold">₹ ${medicine.price - ((currentOffer.discount * medicine.price) / 100)}</p>			                		
            	</c:if>
            	<c:if test="${currentOffer == null}">
            		<p id="medicine-price" class="text-xl font-semibold">₹ ${medicine.price}</p>
              	</c:if>		
            </div>
            	
			<t:button type="submit" value="Place an Order"></t:button>
			<t:button-with-link other="bg-red-700 hover:bg-red-800" link="/" value="Cancel Order" />
			
		</form>
		
		
		<script>
			const quantityElement = document.getElementById("medicine-quantity");
			const priceElement = document.getElementById("medicine-price");
			const oldPriceElement = document.getElementById("old-medicine-price");
			const price = ${medicine.price};
			
			<c:if test="${currentOffer != null}">
				const discount = ${currentOffer.discount};
			
				quantityElement.addEventListener("change", (e) => {
					oldPriceElement.textContent = Number(e.target.value) * price;
					priceElement.textContent = Number(e.target.value) * (price - (discount * price / 100));
					oldPriceElement.textContent = "₹ " + oldPriceElement.textContent;
					priceElement.textContent = "₹ " + priceElement.textContent;
				});
				
			</c:if>

			<c:if test="${currentOffer == null}">
				quantityElement.addEventListener("change", (e) => {
					priceElement.textContent = Number(e.target.value) * price;
					priceElement.textContent = "₹ " + priceElement.textContent;
				});
  			</c:if>		
			
		</script>
		
	</main>
	
		
	
</t:wrapper>



