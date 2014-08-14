package examples.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;

import examples.dto.Customer;


@S2Dao(bean = Customer.class)
public interface CustomerDao {
	
	public List<Customer> getAllCustomer();

}
