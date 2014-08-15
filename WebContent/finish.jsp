<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thanh toán thành công</title>
</head>
<body>

<h3>Hi ${user}, tổng sách: ${tongsach}, tổng tiền: ${tongtien}</h3>
<h3>Thanh toán thành công</h3>
<s2struts:link action="@{loginAction.goHome}"><button>Tiếp tục mua sắm</button></s2struts:link>

<hr/>
The Shop Online Project

</body>
</html>