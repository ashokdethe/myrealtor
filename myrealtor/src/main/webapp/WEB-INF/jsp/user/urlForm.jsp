<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="messages">
	<form:errors path="user.*" cssClass="errors" />
</div>

<form:form modelAttribute="user">
	<fieldset>
		<h4>Provider Webservice Info</h4>
		<br/>
		
		<div class="field">
			<div class="label">
				<label for="url">URL</label>
			</div>
			<div class="input_long">
				<form:input path="url" maxlength="300" size="300"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "url",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true, style: "width: 530px;" }}));
				</script>
			</div>
		</div>


		<div class="buttonGroup">
			<input type="submit" name="_eventId_confirm" id="proceed" value="Confim"/>&#160;
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));
			</script>			
			<input type="submit" name="_eventId_cancel" value="Cancel"/>&#160;
		</div>
	</fieldset>
</form:form>