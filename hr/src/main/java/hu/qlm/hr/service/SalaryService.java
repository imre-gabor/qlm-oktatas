package hu.qlm.hr.service;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hu.qlm.hr.mapper.EmployeeDynamicSqlSupport.*;
import hu.qlm.hr.mapper.EmployeeMapper;
import hu.qlm.hr.model.Employee;

@Service
public class SalaryService {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public void setNewSalary(Employee employee) {
		double payRaisePercent = employeeService.getPayRaisePercent(employee);
		employee.setSalary((int) (employee.getSalary() * (100 + payRaisePercent) / 100));
	}
	
	@Transactional
	public void raiseSalaryByJob(String jobPrefix) {
		employeeMapper.select(c -> c.where(job, isLikeCaseInsensitive(jobPrefix + "%")))
		.forEach(emp -> {
			setNewSalary(emp);
			employeeMapper.updateByPrimaryKey(emp);
		});
	}
}
