package hu.qlm.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.qlm.hr.service.DefaultEmployeeService;
import hu.qlm.hr.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultConfiguration {

	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}
}
