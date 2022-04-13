<nav class="p-4 flex items-center justify-between">
	<div class="flex items-center space-x-2">
		<img class="w-6 h-6" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/syringe_1f489.png">
		<h2 class="font-semibold">Zoho Pharma</h2>
		 <span class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-gray-100 text-gray-800">
    		${(sessionScope.user != null) ? sessionScope.user.getRole() : ""}
  		</span>
	</div>
	<p class="flex items-center">
		<span class="text-sm text-gray-700">${(sessionScope.user != null) ? sessionScope.user.getName() : "Guest User"}</span>
		<img class="w-6 h-6 mx-2" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/google/313/man-health-worker_1f468-200d-2695-fe0f.png">
		<a class="font-semibold text-indigo-900" href="/auth/logout">${ (sessionScope.user != null) ? "Logout": ""}</a>
	</p>
</nav>