<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>MyRealtor: The easiest way to find your new home</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
	<style type="text/css" media="screen">
        @import url("<c:url value="/resources/css-framework/css/tools.css" />");
        @import url("<c:url value="/resources/css-framework/css/typo.css" />");
        @import url("<c:url value="/resources/css-framework/css/forms.css" />");
        @import url("<c:url value="/resources/css-framework/css/layout-navtop-localleft.css" />");
        @import url("<c:url value="/resources/css-framework/css/layout.css" />");
        @import url("<c:url value="/resources/styles/basic.css" />");
    </style>
    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
    
    <script type="text/javascript">
    dojo.require("dijit.form.Button");
    dojo.require("dijit.Dialog");
    
    function showDialog(msg, formVar, urlStr){
    	var secondDlg = new dijit.Dialog( {
            title: "Please Wait",
            style: "width: 300px"
        }); 
        secondDlg.attr("content", msg);
        secondDlg.show();

        if (formVar != null) {
        	formVar.submit();        	
        } else {
        	window.location.href = urlStr;
        }
        
        
    }
    
</script>
    
    
</head>
<body class="tundra spring">
<div id="page">
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
					<a href='<c:url value="/spring/jsp/user"/>'>New user?</a> | 
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
	<li><a href='<c:url value="/spring/rent/index"/>'>Pay your Rent</a></li>
	<li><a href='<c:url value="/spring/tools/index"/>'>Tools</a></li>
	<li><a href='<c:url value="/spring/myaccount/index"/>'>My Account</a></li>
	<li><a href='<c:url value="/spring/providers/index"/>'>Providers</a></li>
</ul>
</div>	
	
	<div id="content" class="clearfix spring">		
		<tiles:insertAttribute name="body" />		
	</div>
	
	<div id="footer" class="clearfix spring">	
		<center>	
		<table>
		<tr><td>MyRealtor ${version}: <br/><br/></td></tr>
		<tr><td>Edson Ricardo Amboni</td></tr>
		<tr><td>Kevin Gilmore</td></tr>
		<tr><td>Reginald Jenkins</td></tr>
		</table>
		</center>
	</div>		
</div>
</body>
</html>