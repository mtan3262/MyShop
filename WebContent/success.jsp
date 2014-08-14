<tiles:insert beanName="main">
  <tiles:put name="title" value="LoginSuccess" />
  <tiles:put name="body" type="string">
 
    <bean:define id="form" name="loginForm" />
    
    <table class="tablebg" border=1>
    <tr class="label">
      <th>Tên sách</th>
      <th>Giá sách</th>
    </tr>
    <c:forEach var="e" varStatus="s" items="${book}">
      <tr>
        <td ><c:out value="${e.tensach}" /></td>
        <td ><c:out value="${e.giasach}" /></td>
        <td>
          	<s2struts:link action="@(bookAction.goDetail}" cancel="true" paramName="e" paramProperty="tensach"><bean:message key="button.edit" /></s2struts:link>
        </td>
      </tr>
    </c:forEach> 
     </table>
  </tiles:put>
  
    
 
</tiles:insert>