<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="messages">
	<form:errors path="user.*" cssClass="errors" />
</div>

<form:form modelAttribute="user">
	<fieldset>
		<h4>User Address Information</h4>
		<br/>
		<div class="field">
			<div class="label">
				<label for="address1">Address #1</label>
			</div>
			<div class="input">
				<form:input path="address1" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "address1",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true }}));
				</script>
			</div>
		</div>


		<div class="field">
			<div class="label">
				<label for="address2">Address #2</label>
			</div>
			<div class="input">
				<form:input path="address2" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "address2",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : false }}));
				</script>
			</div>
		</div>


		<div class="field">
			<div class="label">
				<label for="city">City:</label>
			</div>
			<div class="input">
				<form:input path="city" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "city",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true }}));
				</script>
			</div>
		</div>

		<div class="field">
			<div class="label">
				<label for="state">State:</label>
			</div>
			<div class="input">
				<form:input path="state" maxlength="2"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "state",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true }}));
				</script>
			</div>
		</div>


		<div class="field">
			<div class="label">
				<label for="zip">Zip:</label>
			</div>
			<div class="input">
				<form:input path="zip" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "zip",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : true }}));
				</script>
			</div>
		</div>

		<div class="field">
			<div class="label">
				<label for="phone">Phone:</label>
			</div>
			<div class="input">
				<form:input path="phone" maxlength="40"/>
				<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "phone",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { required : false }}));
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