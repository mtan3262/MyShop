package examples.service.impl;
/**
*Dịch vụ kiểm tra hợp lệ khi login
*@author Cao.Tan
*@version 1.0	 
*/
import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;

import examples.dao.CustomerDao;
import examples.dto.Customer;
import examples.form.LoginForm;
import examples.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	@Resource
	private CustomerDao customerDao;
	
	

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
