
<table class="tablebg" border=1>
	    <tr class="label">
	      <th>Tên sách</th>
	      <th>Giá sách</th>
	      <th>Mã sách</th>
	      <th>Tên loại</th>
	      <th>Số lượng còn</th>
	      <th>Tác giả</th>
	      <th>Số lượng mua</th>
	    </tr>
	      <tr>
	        <td ><c:out value="${book.tensach}" /></td>
	        <td ><c:out value="${book.giasach}" /></td>
	        <td ><c:out value="${book.masach}" /></td>
	        <td ><c:out value="${book.tenloai}" /></td>
	        <td ><c:out value="${book.soluong}" /></td>
	        <td ><c:out value="${book.tacgia}" /></td>
	        <form action="invoice.do">
	        <td><input type="text" name="soluongmua" value="1"></td> 
	        <td>
        		<input name="masach" value="${book.masach}" style="visibility: hidden; width: 5px;height: 0px;">
        		<input name="giasach" value="${book.giasach}" style="visibility: hidden; width: 5px;height: 0px;">
        		<input name="book" value="${book}" style="visibility: hidden; width: 5px;height: 0px;">
        		<input type="text" name="soluongcon" value="${book.soluong}" style="visibility: hidden; width: 5px;height: 0px;">
          		<s2struts:submit action="@(buyAction.goInvoice}" value="Mua"></s2struts:submit>
		     </td>
		     </form>
	      </tr> 
    </table>
    <%= request.getAttribute("error") %>
   
  <br><button><s2struts:link action="@{loginAction.goHome}">Trở về</s2struts:link></button>  

