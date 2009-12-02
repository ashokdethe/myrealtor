<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>




<div class="section">
<h3>My Apartment List</h3>
<br/><br/><br/>



<table class="summary">

	<thead>
		<tr>			
			<th>Number</th>
			<th>Address</th>
			<th>Price</th>
			<th>Owner</th>
			
		</tr>
	</thead>
	<tbody>
	
<c:forEach items="${apartmentList}" var="apt"> 

<tr>
<td>${apt.number}</td> 
<td>${apt.address}</td>
<td>${apt.pricePerMonth}</td>
<td>${apt.owner.username}</td>
</tr>

</c:forEach>

</tbody>
</table>


<br/>
<a href='<c:url value="/spring/myaccount/index"/>'>Go back</a>


</div>

