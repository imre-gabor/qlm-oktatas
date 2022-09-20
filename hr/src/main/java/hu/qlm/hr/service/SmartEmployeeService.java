package hu.qlm.hr.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.qlm.hr.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Autowired
	private HrConfigProperties hrConfig;
	
	@Override
	public double getPayRaisePercent(Employee employee) {
		long yearsWorking = ChronoUnit.YEARS.between(employee.getWorksSince(), 
				LocalDateTime.now());
		if(yearsWorking < hrConfig.getPayRaiseLimitInYears())
			return hrConfig.getPayRaiseBeforeLimit();
		else
			return hrConfig.getPayRaiseAfterLimit();
	}
}
