<html>
<head></head>
<body>
  <html:form action="/login">
    <bean:define id="form" name="loginForm" />
    <html:text property="username" styleClass="text" errorStyleClass="text-error" /><br> 
    <html:text property="password" styleClass="text" errorStyleClass="text-error" /><br>
    <s2struts:submit action="@{loginAction.execute}">login</s2struts:submit>
  </html:form>
  </body>
</html>