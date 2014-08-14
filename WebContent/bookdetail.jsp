<tiles:insert beanName="main">
  <tiles:put name="title" value="Book Detail" />
  <tiles:put name="body" type="string">
 <bean:define id="form" name="bookForm" />
   <table class="tablebg" border=1>
	    <tr class="label">
	      <th>Tên sách</th>
	      <th>Giá sách</th>
	      <th>Mã sách</th>
	      <th>Mã loại</th>
	      <th>Số lượng</th>
	    </tr>
	    <bean:write name="form" property="books"/>
	    <c:forEach var="e" varStatus="s" items="${books}">
	      <tr>
	        <td ><c:out value="${e.tensach}" /></td>
	        <td ><c:out value="${e.giasach}" /></td>
	        <td ><c:out value="${e.giasach}" /></td>
	        <td ><c:out value="${e.giasach}" /></td>
	        <td ><c:out value="${e.giasach}" /></td>
	      </tr>
    </c:forEach> 
    </table>
</tiles:put>
</tiles:insert>