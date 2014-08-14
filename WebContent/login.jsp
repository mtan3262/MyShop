<tiles:insert beanName="main">
  <tiles:put name="title" value="Login" />
  <tiles:put name="body" type="string">
  <html:form action="/login">
    <bean:define id="form" name="loginForm" />
    <html:text property="username" styleClass="text" errorStyleClass="text-error" /><br> 
    <html:text property="password" styleClass="text" errorStyleClass="text-error" /><br>
    <s2struts:submit action="@{loginAction.execute}">login</s2struts:submit>
  </html:form>
  </tiles:put>
</tiles:insert>