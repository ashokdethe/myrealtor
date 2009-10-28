<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<tiles:insertAttribute name="head" />

  
<body class="tundra spring" onload="load()" onunload="GUnload()">

<div id="page">
	<tiles:insertAttribute name="header" />
	
	<div id="content" class="clearfix spring">				
		<tiles:insertAttribute name="body" />				
	</div>	
	
	<tiles:insertAttribute name="footer" />	
	
</div>


</body>
</html>