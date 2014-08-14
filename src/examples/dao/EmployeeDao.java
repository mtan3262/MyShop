package examples.dao;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.S2Dao;




import examples.dto.Employee;

@S2Dao(bean = Employee.class)
public interface EmployeeDao {
	
	@Arguments("empno")
    public String getName(int empno);

}
