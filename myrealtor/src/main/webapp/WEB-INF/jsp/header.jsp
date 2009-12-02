<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



	<div id="header" class="clearfix spring">
		<div id="welcome">
			<div class="left"><a href="<c:url value="/" />">MyRealtor: the easiest way to find a new home!</a></div>
			<div class="right">
				<security:authorize ifAnyGranted="ROLE_USER, ROLE_PROVIDER">
					<c:if test="${pageContext.request.userPrincipal != null}">
						Welcome ${pageContext.request.userPrincipal.name} |
					</c:if>
					<a href="<c:url value="/spring/logout" />">Logout</a>
				</security:authorize>
				<security:authorize ifAllGranted="ROLE_ANONYMOUS">
					<a href='<c:url value="/spring/jsp/user?role=ROLE_PROVIDER"/>'>New provider?</a> |
					<a href='<c:url value="/spring/jsp/user?role=ROLE_USER"/>'>New user?</a> | 
					<a href="<c:url value="/spring/login" />">Login</a>
				</security:authorize>
			</div>
		</div>
		<div id="branding" class="spring">
			<center>
			<a href="<c:url value="/" />"><img src="<c:url value="/resources/images/header.jpg"/>" alt="MyRealtor" /></a>
			</center>
		</div>
		
	</div>
	
<div id="navcontainer">
<ul id="navlist">	
	<li><a href='<c:url value="/spring/intro"/>'>Home</a></li>
	<li><a href='<c:url value="/spring/search/index"/>' >Search a new Home</a></li>		
	<li><a href='<c:url value="/spring/myaccount/index"/>'>My Account</a></li>
	<security:authorize ifAllGranted="ROLE_PROVIDER">
	<li><a href='<c:url value="/spring/provider/index"/>'>Providers</a></li>
	</security:authorize>
</ul>
</div>	

