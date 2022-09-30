package hu.qlm.hr.web;

import java.util.List;

import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.qlm.hr.mapper.EmployeeMapper;
import hu.qlm.hr.model.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping
	public List<Employee> findAll(){
		return employeeMapper.select(SelectDSLCompleter.allRows());
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable int id){
		return employeeMapper.selectByPrimaryKey(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		employeeMapper.insert(employee);
		return employee;
	}
	
	@PutMapping("/{id}")
	public Employee update(@PathVariable int id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeMapper.updateByPrimaryKey(employee);
		return employee;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	
}
