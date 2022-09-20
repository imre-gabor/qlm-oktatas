package hu.qlm.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.qlm.hr.service.EmployeeService;
import hu.qlm.hr.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartConfiguration {

	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService();
	}
}
