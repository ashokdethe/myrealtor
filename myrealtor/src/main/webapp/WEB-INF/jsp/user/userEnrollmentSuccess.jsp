<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="messages">
	<form:errors path="user.*" cssClass="errors" />
</div>

<div class="section">
<h3>Thanks for your enrollment!</h3>

<br/><br/>
<h6>Your username is: ${user.username}</h6>
<h6>Your password is: ${user.password}</h6>



<br/><br/><br/><br/>
Try <a href="<c:url value="/spring/login" />">Login</a> now
</div>