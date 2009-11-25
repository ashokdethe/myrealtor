<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="section">
<h3>List Apartment Provider: ${provider.username}</h3>
<h3>Address: ${address}</h3>
<br/><br/><br/>



<table class="summary">

	<thead>
		<tr>
			<th>Status</th>
			<th>Number</th>
			<th>Price</th>			
		</tr>
	</thead>
	<tbody>
	
<c:forEach items="${apartmentList}" var="apt"> 

<tr> 
<td>${apt.status}</td> 
<td>${apt.number}</td> 
<td>${apt.pricePerMonth}</td>
</tr>

</c:forEach>

</tbody>
</table>


<br/>
<a href='<c:url value="/spring/provider/index"/>'>Go back</a>


</div>

