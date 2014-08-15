<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi Tiết Hóa Đơn</title>
</head>
<body>

<h3>Hi ${user}, tổng sách: ${tongsach}, tổng tiền: ${tongtien}</h3>

<table border= 1>
	<tr>
		<th>Tên Sách</th>
		<th>Giá sách</th>
		
		</tr>
	<tbody>
		 <c:forEach var="e" varStatus="s" items="${listbook}">
      <tr >
        <td class="text"><c:out value="${e.tensach}" /></td>
        <td class="number"><c:out value="${e.giasach}" /></td>
        </tr>
		</c:forEach> 
	</tbody>
</table>
<s2struts:link action="@{updateAction.goUpdate}"><button>Thanh toán</button></s2struts:link>
<s2struts:link action="@{loginAction.goHome}"><button>Trở về</button></s2struts:link>

<hr/>
The Shop Online Project

</body>
</html>