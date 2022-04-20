

<%@tag description="Success Alert Box" %>

<% if(request.getAttribute("successMessage") != null) { %> 
	
	 <div class="max-w-xl mx-auto rounded-md bg-green-50 p-4">
		 <div class="flex justify-center">
		   <div class="flex-shrink-0">
		     <svg class="h-5 w-5 text-green-400" x-description="Heroicon name: solid/check-circle" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
		       <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd"></path>
		     </svg>
		   </div>
		   <div class="ml-3">
		     <p class="text-sm font-medium text-green-800">${successMessage}</p>
		   </div>
		</div>
	</div>
<% } %>