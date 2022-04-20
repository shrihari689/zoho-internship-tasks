<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Medicines List | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="mx-5 py-10">
		
		 <table class="max-w-4xl w-full mx-auto divide-y divide-gray-200">
            <thead class="bg-gray-50">
              <tr>
              	<th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  ID
                </th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Name
                </th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Quantity
                </th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Price
                </th>
                <th scope="col" class="px-6 py-3 text-right text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Action
                </th>
              </tr>
            </thead>
            <tbody>
				<c:forEach var="item" items="${medicines}">	
					<tr class="bg-white hover:bg-gray-100">
	                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
	                    ${item.id}
	                  </td>
	                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">
	                    ${item.name}
	                  </td>
	                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-800">
	                    ${item.quantity}
	                  </td>
	                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-800">
	                    ₹ ${item.price}
	                  </td>
	                  <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
	                    <a href="/app/admin/medicines/${item.id}" class="text-indigo-600 hover:text-indigo-900">View</a>
	                  </td>
                	</tr>
		      	</c:forEach>
				
             </tbody>
		</table>
		
	</main>
	
</t:wrapper>



