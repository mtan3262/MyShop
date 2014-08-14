 <tiles:insert beanName="main">
  <tiles:put name="title" value="Add" />
  <tiles:put name="body" type="string">
  <html:form action="/book">
    <bean:define id="form" name="bookForm" />
    <html:text property="empno" styleClass="number" errorStyleClass="number-error" /> 
    Nhân Viên<bean:write name="form" property="ename"/><br />
    <s2struts:submit action="@{bookAction.execute}">Find</s2struts:submit>
  </html:form>
  </tiles:put>
</tiles:insert>