package examples.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;

import examples.dto.Customer;

/**
 *Thao tác với bảng khách hàng trong cơ sở dũ liệu 
 *@author Cao.Tan
 *@version 1.0	 
 */
@S2Dao(bean = Customer.class)
public interface CustomerDao {
	
	public List<Customer> getAllCustomer();
	
	public String getCustomerCode(String TenKhachHang);

}
