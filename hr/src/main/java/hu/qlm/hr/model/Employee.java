package hu.qlm.hr.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class Employee {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8186884+02:00", comments="Source field: employee.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.job")
    private String job;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.salary")
    private Integer salary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.works_since")
    private LocalDateTime worksSince;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8176896+02:00", comments="Source Table: employee")
    public Employee(Integer id, String name, String job, Integer salary, LocalDateTime worksSince) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.worksSince = worksSince;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8186884+02:00", comments="Source Table: employee")
    public Employee() {
        super();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8196854+02:00", comments="Source field: employee.job")
    public String getJob() {
        return job;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.job")
    public void setJob(String job) {
        this.job = job;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.salary")
    public Integer getSalary() {
        return salary;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.salary")
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.works_since")
    public LocalDateTime getWorksSince() {
        return worksSince;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8206815+02:00", comments="Source field: employee.works_since")
    public void setWorksSince(LocalDateTime worksSince) {
        this.worksSince = worksSince;
    }
}