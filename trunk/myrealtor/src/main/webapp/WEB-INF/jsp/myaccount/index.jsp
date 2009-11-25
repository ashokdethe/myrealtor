<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="section">
<h3>My Account</h3>
<br/><br/><br/>
<ul>
	<security:authorize ifAllGranted="ROLE_USER">
	<li><a href='<c:url value="/spring/myaccount/"/>' >My apartments</a></li>
	</security:authorize>		
	<li><a href='<c:url value="/spring/myaccount/"/>'>Update Personal Info</a></li>
</ul>
</div>