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
			<th>Rent</th>			
		</tr>
	</thead>
	<tbody>
	
<c:forEach items="${apartmentList}" var="apt"> 

<tr> 
<td>${apt.status}</td> 
<td>${apt.number}</td> 
<td>${apt.pricePerMonth}</td> 
<td>Rent</td>
</tr>

</c:forEach>

</tbody>
</table>


</div>

