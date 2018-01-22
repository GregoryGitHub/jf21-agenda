<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="false" %>

<input id="${ id }" name="${ name }">
<script>
	$('#${id}').datepicker({dateFormat: 'dd/mm/yy'});
</script>