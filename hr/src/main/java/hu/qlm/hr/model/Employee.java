package hu.qlm.hr.model;

import java.time.LocalDateTime;

public class Employee {
	
	private Integer id;
	private String name;
	private String job;
	private int salary;
	private LocalDateTime worksSince;
	
	public Employee() {
	}
	
	public Employee(Integer id, String name, String job, int salary, LocalDateTime worksSince) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.worksSince = worksSince;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDateTime getWorksSince() {
		return worksSince;
	}
	public void setWorksSince(LocalDateTime worksSince) {
		this.worksSince = worksSince;
	}

	
}
