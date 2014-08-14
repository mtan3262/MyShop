package examples.service.impl;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;

import examples.dao.CustomerDao;
import examples.dto.Customer;
import examples.form.LoginForm;
import examples.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private CustomerDao customerDao;
	
	@Binding(bindingType = BindingType.MUST)
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Boolean CheckLogin(LoginForm login) {

		List<Customer> customers = customerDao.getAllCustomer();
		for(int i = 0; i < customers.size(); i++){
			if(login.getUsername().equals(customers.get(i).getTenKhachHang()))
			{
				if(login.getPassword().equals(customers.get(i).getPassword()))
					return true;
				else
					return false;
			}
		}
		return false;
	}


	
	}
