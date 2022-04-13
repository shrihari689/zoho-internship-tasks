<%@tag description="Input Tag" %>
<%@attribute name="name" required="true" %>
<%@attribute name="placeholder" required="true" %>
<%@attribute name="label" required="true" %>
<%@attribute name="type" required="true" %>
<%@attribute name="other" required="true" %>

<div class="flex flex-col items-start space-y-2 w-full my-2">
	<label for="${name}" class="text-gray-700">${label}</label>
	<input class="ring-2 w-full ring-gray-300 rounded-md outline-none px-2 py-1" name="${name}" placeholder="${placeholder}" type="${type}" ${other}>
</div>

