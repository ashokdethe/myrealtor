<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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



<div class="section">
<h3>Search</h3>
<br/><br/><br/>
<table>
<tr> <td>Enter ZIP code</td> <td> <input type="text"> </td> <td> <input type="submit" value="Search"> </td> </tr>
</table>
</div>


<center>
<table border="1">
	<tr>
		<td>
		<div id="map" style="width: 700px; height: 300px" />
		</td>
	</tr>
</table>
</center>

