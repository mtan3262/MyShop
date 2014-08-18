
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
        	<form action="book.do">
        		<input name="masach" value="${e.masach}" style="visibility: hidden; width: 5px;height: 0px;">
          		<s2struts:submit action="@(bookAction.goDetail}" value="Chi tiết"></s2struts:submit>
          	</form>
        </td>
      </tr>
    </c:forEach> 
     </table>

