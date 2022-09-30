package hu.qlm.hr;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.qlm.hr.mapper.EmployeeMapper;
import hu.qlm.hr.model.Employee;
import hu.qlm.hr.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	SalaryService salaryService;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee(null, "Kovács Géza", "fejlesztő", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		Employee employee2 = new Employee(null, "Kovács Géza2", "fejlesztő", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		Employee employee3 = new Employee(null, "Kovács Géza3", "rendszergazda", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		/*
		salaryService.setNewSalary(employee);
		System.out.format("Employee with name %s has salary %d, works since %s%n", 
				employee.getName(), employee.getSalary(), employee.getWorksSince());
				*/
		
		employeeMapper.insert(employee);
		employeeMapper.insert(employee2);
		employeeMapper.insert(employee3);
		
		salaryService.raiseSalaryByJob("FEjl");
	}

}
