<tiles:insert beanName="main">
  <tiles:put name="title" value="LoginSuccess" />
  <tiles:put name="body" type="string">
    <table class="tablebg" border=1>
	    <tr class="label">
	      <th>Tên sách</th>
	      <th>Giá sách</th>
	      <th>Mã sách</th>
	      <th>Mã loại</th>
	      <th>Số lượng</th>
	      <th>Tác giả</th>
	    </tr>
	      <tr>
	        <td ><c:out value="${book.tensach}" /></td>
	        <td ><c:out value="${book.giasach}" /></td>
	        <td ><c:out value="${book.masach}" /></td>
	        <td ><c:out value="${book.maloai}" /></td>
	        <td ><c:out value="${book.soluong}" /></td>
	        <td ><c:out value="${book.tacgia}" /></td>
	      </tr> 
    </table>
 </tiles:put>
</tiles:insert>