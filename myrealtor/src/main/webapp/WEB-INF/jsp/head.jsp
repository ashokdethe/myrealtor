<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
    
    <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAA0-70fEREB0bsUCfT2s76ZxTwM0brOpm-All5BF6PoaKBxRWWERT53KrunpiWSWcDWKLphA0P7n2XZw" type="text/javascript"></script>
    
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


	function setFocus() {
		var field = dijit.byId("address.address1");
		if ( field != null) {
			field.focus();
			return;
		} 
				
		field = dijit.byId("firstName");
		if (field != null) {
			field.focus();
			return;
		}

		field = dijit.byId("url");
		if (field != null) {
			field.focus();
			return;
		}

		field = dijit.byId("criteria");
		if (field != null) {
			field.focus();
			return;
		}
		
	}	
    
    
</script>

    
    
</head>

