
<html>
<head></head>
<body>   

<h3>Hi ${user}, tổng sách: ${tongsach}, tổng tiền: ${tongtien}</h3>
<br>
<table class="tablebg" border=1>
	    <tr class="label">
	      <th>Tên sách</th>
	      <th>Giá sách</th>
	      <th>Mã sách</th>
	      <th>Tên loại</th>
	      <th>Số lượng</th>
	      <th>Tác giả</th>
	    </tr>
	      <tr>
	        <td ><c:out value="${book.tensach}" /></td>
	        <td ><c:out value="${book.giasach}" /></td>
	        <td ><c:out value="${book.masach}" /></td>
	        <td ><c:out value="${book.tenloai}" /></td>
	        <td ><c:out value="${book.soluong}" /></td>
	        <td ><c:out value="${book.tacgia}" /></td>
	      </tr> 
    </table>
    <form action="invoice.do">
        		<input name="masach" value="${book.masach}" style="visibility: hidden; width: 5px;height: 0px;">
        		<input name="giasach" value="${book.giasach}" style="visibility: hidden; width: 5px;height: 0px;">
          		<s2struts:submit action="@(buyAction.goInvoice}" value="Mua"></s2struts:submit>
     </form>
    <s2struts:link action="@{loginAction.goHome}">Trở về</s2struts:link>
    
<hr/>
The Shop Online Project
    </body>
</html>
