<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>

<h1>Login</h1>

<div class="section">
	<c:if test="${not empty param.login_error}">
		<div class="errors">
			Your login attempt was not successful, try again.<br /><br />
			Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
		</div>
	</c:if>
	
		
	New user? Go to <a href='<c:url value="/spring/jsp/user?role=ROLE_USER"/>'>Create new User Account</a> <br/><br/>
	New provider? Go to <a href='<c:url value="/spring/jsp/user?role=ROLE_PROVIDER"/>'>Create new Provider Account</a>		
	<br/><br/><br/><br/>
</div>

<div class="section">
	<form name="f" action="<c:url value="/spring/loginProcess" />" method="post">
		<fieldset>
		<p>Try Test User: TEST1234/1234 </p>
			
			<div class="field">
				<div class="label">Username:</div>
				<div class="output">
					<input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value="<%= session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>"</c:if> />
					<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "j_username",
							widgetType : "dijit.form.ValidationTextBox",
							widgetAttrs : { promptMessage : "Your userid", required : true }}));
					</script>
				</div>
			</div>
			
			
			<div class="field">
				<div class="label">Password:</div>
				<div class="output">
					<input type="password" name="j_password" id="j_password" />
					<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "j_password",
							widgetType : "dijit.form.ValidationTextBox",
							widgetAttrs : { promptMessage : "Your password", required : true}}));
					</script>
				</div>
			</div>
			<div class="field">
				<div class="label"><label for="remember_me">Don't ask for my password for two weeks:</label></div>
				<div class="output">
					<input type="checkbox" name="_spring_security_remember_me" id="remember_me" />
					<script type="text/javascript">
						Spring.addDecoration(new Spring.ElementDecoration({
							elementId : "remember_me",
							widgetType : "dijit.form.CheckBox"}));
					</script>
				</div>
			</div>
			
			
		<div class="buttonGroup">
			<input name="submit" id="submit" type="submit" value="Login" />
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
			</script>
		</div>
			
			
		</fieldset>
	</form>
	
	<br/><br/>
	Forgot your username or password? Go to <a href='<c:url value="/spring/user/recoverPasswordForm"/>'>Recover username or password</a>
	
</div>



