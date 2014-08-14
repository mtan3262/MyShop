<tiles:insert beanName="main">
  <tiles:put name="title" value="Add" />
  <tiles:put name="body" type="string">
  <html:form action="/add">
    <bean:define id="form" name="addForm" />
    <html:text property="arg1" styleClass="number" errorStyleClass="number-error" /> + 
    <html:text property="arg2" styleClass="number" errorStyleClass="number-error" /> = 
    <bean:write name="form" property="result"/><br />
    <s2struts:submit action="@{addAction.calculate}">calculate</s2struts:submit>
  </html:form>
  </tiles:put>
</tiles:insert>