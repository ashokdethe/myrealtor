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

    	
    	//var gicon = new GIcon(G_DEFAULT_ICON, "/resources/images/house.png");
    	var gicon = new GIcon(G_DEFAULT_ICON, '<c:url value="/resources/images/house.png"/>');
    	
    	//var new_icon = new GIcon();
		//new_icon.image = "images/house.png";
		//new_icon.size = new GSize(16,16);  
		//new_icon.iconAnchor = new GPoint(8,9);  
		//new_icon.infoWindowAnchor = new GPoint(7,7);  
    	

    	var usCenterPoint = new GLatLng( 37.4419, -122.1419 );

    	//var marker = new GMarker(new GLatLng( 37.4419, -122.1419 ));
    	//marker.bindInfoWindowHtml("Test");
    	var marker = null;
    	
    	<c:forEach items="${apartmentList}" var="apt">    	

    	    	
    	<c:if test="${apt.readOnly}">
    	marker = new GMarker( new GLatLng( ${apt.address.latitude}, ${apt.address.longitude} ) );
    	marker.bindInfoWindowHtml("${apt.address}");
    	</c:if>
    	<c:if test="${! apt.readOnly}">
    	marker = new GMarker( new GLatLng( ${apt.address.latitude}, ${apt.address.longitude} ), gicon );
    	marker.bindInfoWindowHtml("${apt.address}" + "<br/><br/><br/>" + "<a href='<c:url value='/spring/search/list?username=${apt.owner.username}&zip=${apt.address.zip}'/>'>Show List Available Apartments</a>");    	
    	</c:if>
    	    	
    	
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

