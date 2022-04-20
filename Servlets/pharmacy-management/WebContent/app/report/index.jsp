<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Report Issue | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="p-5 mx-5">
	
		<header>
			<h1 class="font-bold text-xl">Report an Issue</h1>
			<p class="text-sm text-gray-600 font-light">We will get back to you soon</p>	
		</header>
	
		<section class="my-5">
			<h2 class="font-semibold">Recent Reports</h2>
			
			<div class="flex flex-col items-center justify-center py-5">
				<c:if test="${reports.size() == 0}">
					<img class="h-24 w-24 mb-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/open-mailbox-with-raised-flag_1f4ec.png">
					<p class="text-gray-600">You have no messages</p>
				</c:if>
				
				<c:if test="${reports.size() > 0}">
					
					<div class="flex flex-col w-full border-b-2 border-t-2 border-gray-200">
						<c:forEach var="item" items="${reports}">				
						    <div class="w-full border-x-2 ${((item.lastMessage.fromUserId == requestScope.userId) || (item.lastMessage.read)) ? 'bg-gray-100':  'border-x-indigo-800'} p-2">
						      <div class="grid grid-cols-12 divide-x-2">
						        <div class="col-span-1 flex-1 flex items-center justify-center">#${item.id}</div>
						        <a href="/reports/${item.id}" class="col-span-10 px-2 hover:text-indigo-700 hover:underline flex flex-col">
						          <h2 class="font-semibold w-full truncate">${item.title}</h2>
						          <c:if test="${item.lastMessage != null}">
							          <p class="w-full truncate font-light">${item.lastMessage.message}</p>
						          </c:if>
						        </a>
						        <div class="col-span-1 flex-1 flex justify-center items-center">
						          <c:if test="${item.status == 'OPENED'}">
							          <img class="h-6" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/high-voltage_26a1.png" title="In Progress" alt="Progress" />
						          </c:if>
						          <c:if test="${item.status == 'CLOSED'}">
						          	<img class="h-6" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/check-mark-button_2705.png" title="In Progress" alt="Progress" />
						          </c:if>
						          <span class="font-semibold ml-2">${item.status.toString()}</span>
						        </div>
						      </div>
						    </div>
						</c:forEach>
				  	</div>			
				</c:if>
			</div>	
			
		</section>
	
	</main>
	
	
</t:wrapper>



