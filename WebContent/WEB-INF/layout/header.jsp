<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
				<div id="logo">
					<s2struts:link action="@{loginAction.goHome}"><img src="images/logo.png" alt="LOGO"></s2struts:link>
				</div>
				<div id="navigation">
					<ul id="primary">
						
						
					</ul>
					<ul id="secondary">
						<li><a>Hi ${user},tổng sách: ${tongsach}, tổng tiền: ${tongtien}</a></li>
						<li>
							 <s2struts:link action="@(buyAction.viewInvoice}" >Xem giỏ hàng</s2struts:link>
						</li>
						<li>
							<a href="login.jsp">Đăng xuất</a> |<s2struts:link action="@(viewAction.goView}" >Lịch sử mua sắm</s2struts:link>
						</li>
						
					</ul>
					
				</div>
			</div>
</body>
</html>

