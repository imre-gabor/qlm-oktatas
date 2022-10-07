package hu.qlm.hr.web;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.assertj.core.api.Assertions.assertThat;

import hu.qlm.hr.model.Employee;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class EmployeeControllerIT {

	private static final String BASE_URI = "/api/employees";
	
	@Autowired
	WebTestClient webTestClient;
	
	
	@Test
	void testThatCreatedEmployeeIsListed() throws Exception {
		
		List<Employee> employeesBefore = getAllEmployees();
		
		Employee newEmployee = webTestClient
			.post()
			.uri(BASE_URI)
			.bodyValue(new Employee(null, "name", "job", 300000, LocalDateTime.of(2015, 10, 1, 8, 0)))
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(Employee.class)
			.returnResult()
			.getResponseBody();
		
		List<Employee> employeesAfter = getAllEmployees();
		
		assertThat(employeesAfter).hasSize(employeesBefore.size() + 1);
		assertThat(employeesAfter.get(employeesAfter.size() -1))
			.usingRecursiveComparison()
			.isEqualTo(newEmployee);
		
	}


	private List<Employee> getAllEmployees() {
		return webTestClient
			.get()
			.uri(BASE_URI)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBodyList(Employee.class)
			.returnResult()
			.getResponseBody();
	}
	
}
