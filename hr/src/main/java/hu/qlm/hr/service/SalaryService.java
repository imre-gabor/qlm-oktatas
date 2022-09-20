package hu.qlm.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.qlm.hr.model.Employee;

@Service
public class SalaryService {

	@Autowired
	private EmployeeService employeeService;
	
	public void setNewSalary(Employee employee) {
		double payRaisePercent = employeeService.getPayRaisePercent(employee);
		employee.setSalary((int) (employee.getSalary() * (100 + payRaisePercent) / 100));
	}
}
