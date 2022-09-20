package hu.qlm.hr.service;

import org.springframework.stereotype.Service;

import hu.qlm.hr.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Override
	public double getPayRaisePercent(Employee employee) {
		return 5.0;
	}
}
