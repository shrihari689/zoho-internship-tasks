<%@tag description="Simple Button Tag" %>
<%@attribute name="value" required="true" %>
<%@attribute name="link" required="true" %>
<%@attribute name="other" %>

<a href="${link}" class="my-2 inline-flex justify-center items-center px-5 py-1.5 border border-transparent text-center text-sm font-medium rounded-full shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 ${other}">
	${value}
</a>