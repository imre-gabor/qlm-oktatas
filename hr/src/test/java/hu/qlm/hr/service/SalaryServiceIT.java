package hu.qlm.hr.service;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import hu.qlm.hr.mapper.EmployeeDynamicSqlSupport;
import hu.qlm.hr.mapper.EmployeeMapper;
import hu.qlm.hr.model.Employee;

@SpringBootTest
@AutoConfigureTestDatabase
public class SalaryServiceIT {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SalaryService salaryService;
	
	@BeforeEach
	public void init() {
		employeeMapper.delete(DeleteDSLCompleter.allRows());
	}
	
	@Test
	void testRaiseSalaryByJob() throws Exception {
		//ARRANGE
		Employee employee = new Employee(null, "Kovács Géza", "fejlesztő", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		Employee employee2 = new Employee(null, "Kovács Géza2", "fejlesztő", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		Employee employee3 = new Employee(null, "Kovács Géza3", "rendszergazda", 500000, LocalDateTime.of(2020, 9, 17, 8, 0));
		
		employeeMapper.insert(employee);
		employeeMapper.insert(employee2);
		employeeMapper.insert(employee3);
		
		
		//ACT
		salaryService.raiseSalaryByJob("FEjl");
		
		//ASSERT
		List<Employee> employeesAfterRaise = employeeMapper.select(SelectDSLCompleter.allRowsOrderedBy(EmployeeDynamicSqlSupport.id));
		assertThat(employeesAfterRaise.get(0).getSalary()).isEqualTo(550000);
		assertThat(employeesAfterRaise.get(1).getSalary()).isEqualTo(550000);
		assertThat(employeesAfterRaise.get(2).getSalary()).isEqualTo(500000);
	}
	
	
}
