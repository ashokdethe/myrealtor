<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="section">
<h3>Providers</h3>
<br/><br/><br/>
<ul>
	<li><a href='<c:url value="/spring/provider/list?username=${pageContext.request.userPrincipal.name}"/>'>View Apartments List</a></li>
</ul>
</div>