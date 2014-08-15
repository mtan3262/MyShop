<html>
<head></head>
<body>
<table>
  <html:form action="/login">
    <bean:define id="form" name="loginForm" />
    <tr>
    <td>Tên khách hàng:</td>
    <td><html:text property="username" styleClass="text" errorStyleClass="text-error"  /></td>
    </tr>
     <tr>
     <td>Mật khẩu:</td>
     <td><html:text property="password" styleClass="text" errorStyleClass="text-error" /></td>
     </tr>
	<tr>
	<td></td>
	<td> <s2struts:submit action="@{loginAction.execute}">Đăng nhập</s2struts:submit></td>
	</tr>
   
  </html:form>
  </table>
  </body>
</html>