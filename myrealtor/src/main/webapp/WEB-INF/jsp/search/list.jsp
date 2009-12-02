<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>




<div class="section">
<h3>List Apartment Provider: ${provider.email}</h3>
<h3>Address: ${address}</h3>
<br/><br/><br/>



<table class="summary">

	<thead>
		<tr>
			<th>Status</th>
			<th>Number</th>
			<th>Price</th>
			
			<security:authorize ifAllGranted="ROLE_USER">
			<th>Action</th>
			</security:authorize>
		</tr>
	</thead>
	<tbody>
	
<c:forEach items="${apartmentList}" var="apt"> 

<tr> 
<td>${apt.status}</td> 
<td>${apt.number}</td> 
<td>${apt.pricePerMonth}</td>

<security:authorize ifAllGranted="ROLE_USER">
<td><a href='<c:url value="/spring/search/rent?username=${provider.username}&number=${apt.number}"/>'>Rent</a></td>
</security:authorize>


</tr>

</c:forEach>

</tbody>
</table>


<br/>
<a href='<c:url value="/spring/search/repeat?criteria=${zip}"/>'>Go back to Search Result</a>


</div>

