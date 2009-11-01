<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form modelAttribute="criteria" action="search">

<div class="section">
<h3>Search</h3>
<br/><br/><br/>
<table>
<tr> <td>Enter ZIP code</td> 
<td> <form:input path="criteria"/> </td> 
<td> <input type="submit" value="Search"> </td> </tr>
</table>
</div>


</form:form>
