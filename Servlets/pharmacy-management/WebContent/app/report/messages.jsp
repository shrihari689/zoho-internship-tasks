<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Messages - Report | Zoho Pharma">
	 
	<%@include file="/shared/navbar.jsp" %>
	
	<main class="p-5 mx-5">
	
		<header class="flex justify-between w-full">
			<div class="flex-1">
				<h1 class="font-bold text-xl">${report.title}</h1>
				<p class="text-sm text-gray-700 font-medium">ID: <strong class="font-semibold">#${report.id}</strong></p>	
				<p class="text-sm text-gray-700 font-medium">Status: <strong class="font-semibold">${report.status.toString()}</strong></p>	
			</div>
			<div class="flex justify-center items-center">
				<t:button-with-link link="/reports" value="Back" />
			</div>
		</header>
	
		<section class="my-5">
			<div class="flex flex-col items-center justify-center py-5">
				<c:if test="${messages.size() == 0}">
					<img class="h-24 w-24 mb-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/open-mailbox-with-raised-flag_1f4ec.png">
					<p class="text-gray-600">You have no messages</p>
				</c:if>
				
				<c:if test="${messages.size() > 0}">
				
					<main class="px-5 w-full max-w-5xl mx-auto">
					  <div class="rounded-md relative p-2 bg-white px-2 ring-2 w-full ring-gray-100 h-96">
					    <ul id="messages-list" class="flex flex-col py-2 w-full h-full px-4 overflow-y-auto overflow-x-hidden">
					    	<c:forEach var="item" items="${messages}">	
					     		<c:if test="${(item.fromUserId == requestScope.userId) && !item.isAction()}">
					     			<li class="my-2 ml-auto flex flex-col w-full items-end">
					     				<div class="rounded-md bg-gray-100 px-4 py-2">${item.message}</div>
					     				<p class="text-xs my-1 text-gray-500">${item.sentAtString}</p>
								    </li>
					     		</c:if>
					     		<c:if test="${(item.fromUserId != requestScope.userId) && !item.isAction()}">
					     			<li class="my-2 mr-auto flex w-2/3 flex-col items-start">
					     				<div class="rounded-md bg-gray-100 px-4 py-2">${item.message}</div>
								    	<p class="text-xs my-1 text-gray-500">${item.sentAtString}</p>
								    </li>
					     		</c:if>
					     		<c:if test="${item.isAction()}">
					     			<li class="my-2 mx-auto flex w-2/3">
								        <div class="mx-auto flex items-center space-x-1 rounded-md bg-indigo-800 px-4 py-2 text-center text-xs text-gray-50">
								          <img class="h-4" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/high-voltage_26a1.png" title="In Progress" alt="Progress" />
								          <span>${item.message}</span>
								        </div>
								    </li>
					     		</c:if> 
					     	</c:forEach>
					    </ul>
					    
					    <form action="/reports/messages/${report.id}" method="POST" class="w-full absolute bottom-0 left-0 flex">
					    	<input type="text" class="p-2 w-full h-full border-t-2 border-gray-400 focus:border-indigo-800" name="message">
					    	<button type="submit" class="flex justify-center items-center px-5 py-1.5 border border-transparent text-center text-sm font-medium h-full rounded-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500" value=''>
						    	<svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
								  <path stroke-linecap="round" stroke-linejoin="round" d="M13 9l3 3m0 0l-3 3m3-3H8m13 0a9 9 0 11-18 0 9 9 0 0118 0z" />
								</svg>
					    	</button> 
					    </form>
					    
					    <script>
					    	
					    	const messageList = document.getElementById("messages-list");
					    	if(messageList) {
					    		messageList.scroll({ top: messageList.scrollHeight, behavior: 'smooth' });
					    	}
					    	
					    </script>
					    
					  </div>
					</main>
										
				</c:if>
			</div>	
			
		</section>
	
	</main>
	
	
</t:wrapper>



