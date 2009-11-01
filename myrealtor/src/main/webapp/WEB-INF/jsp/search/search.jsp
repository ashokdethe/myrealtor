<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script type="text/javascript">

    
    //var usCenterPoint = new GLatLng( 37.4419, -122.1419 );
    //var usCenterPoint = new GLatLng(${addressInstance.lat}, ${addressInstance.lng});    
	
    
    
    function load() {
      if (GBrowserIsCompatible()) {
    	var usZoom = 12;
        var map = new GMap2(document.getElementById("map"));    	
    	map.addControl(new GLargeMapControl());
    	map.addControl(new GMapTypeControl()); 

    	var usCenterPoint = new GLatLng( 37.4419, -122.1419 );
    	
    	
    	<c:forEach items="${apartmentList}" var="apt">    	
    	//var marker = new GMarker(new GLatLng( 37.4419, -122.1419 ));
    	//marker.bindInfoWindowHtml("Test");
    	var marker = new GMarker(new GLatLng( ${apt.address.latitude}, ${apt.address.longitude} ));
    	marker.bindInfoWindowHtml("${apt.address}");
      	map.addOverlay(marker);
      	
      	usCenterPoint = new GLatLng( ${apt.address.latitude}, ${apt.address.longitude} );

    	</c:forEach>		

      	map.setCenter(usCenterPoint, usZoom);
      	
      }
    }
</script>

<%@include file="searchForm.jsp" %> 

<center>
<table border="1">
	<tr>
		<td>
		<div id="map" style="width: 700px; height: 300px">
		</div>
		</td>
	</tr>
</table>
</center>

