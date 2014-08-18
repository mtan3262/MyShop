
<table border= 1>
	<tr>
		<th>Tên sách</th>
		<th>Giá sách</th>
		<th>Số lượng mua</th>
		<th>Tổng tiền</th>
		
		</tr>
	<tbody>
		 <c:forEach var="e" varStatus="s" items="${listbook}">
      <tr >
        <td class="text"><c:out value="${e.tensach}" /></td>
        <td class="number"><c:out value="${e.giasach}" /></td>
        <td class="number"><c:out value="${e.soluongmua}" /></td>
        <td class="number"><c:out value="${e.tongtienmua}" /></td>
        </tr>
		</c:forEach> 
	</tbody>
</table>
<s2struts:link action="@{updateAction.goUpdate}"><button>Thanh toán</button></s2struts:link>
<s2struts:link action="@{loginAction.goHome}"><button>Trở về</button></s2struts:link>

