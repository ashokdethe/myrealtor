<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="messages">
	<form:errors path="user.*" cssClass="errors" />
	<br/><br/>
</div>

<form:form modelAttribute="user" action="recoverPasswordResult">
	<fieldset>		
		<h4>Recover Username and Password</h4>
		<br/>

		<div class="field">
			<div class="label">
				<label for="email">Email:</label>
			</div>
			<div class="input">
				<form:input path="email" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "email",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true, regExp: "([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})" }}));
				</script>
			</div>
		</div>
		
	
		
	<div class="field">
	<div class="label">Security Question:</div>
	<div class="input"><form:select path="question" itemLabel="question" itemValue="id" items="${securityQuestionList}" />	</div>
	</div>
	
	
	
		<div class="field">
			<div class="label">Security Answer:</div>
			<div class="input"><form:input path="securityAnswer" maxlength="40"/></div>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "securityAnswer",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true }}));
				</script>			
		</div>
	
		
		

		<div class="buttonGroup">
			<input type="submit" id="proceed" name="proceed" value="Recover Info" />
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));
			</script>
		</div>
	</fieldset>
</form:form>