
 	 <table class="tablebg" border=1>
    <tr class="label">
      <th>Số hóa đơn</th>
      <th>Mã Khách hàng</th>
      <th>Ngày xuất</th>
      <th>Tổng tiền</th>
    </tr>
    <c:forEach var="e" varStatus="s" items="${history}">
      <tr>
        <td ><c:out value="${e.sohoadon}" /></td>
        <td ><c:out value="${e.makhachhang}" /></td>
        <td ><c:out value="${e.ngayxuat}" /></td>
        <td ><c:out value="${e.tongtien}" /></td>
      </tr>
    </c:forEach> 
     </table>
     <s2struts:link action="@{loginAction.goHome}"><button>Trở về</button></s2struts:link>