package hu.qlm.hr.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class EmployeeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source Table: employee")
    public static final Employee employee = new Employee();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source field: employee.id")
    public static final SqlColumn<Integer> id = employee.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source field: employee.name")
    public static final SqlColumn<String> name = employee.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source field: employee.job")
    public static final SqlColumn<String> job = employee.job;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source field: employee.salary")
    public static final SqlColumn<Integer> salary = employee.salary;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source field: employee.works_since")
    public static final SqlColumn<LocalDateTime> worksSince = employee.worksSince;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8247517+02:00", comments="Source Table: employee")
    public static final class Employee extends AliasableSqlTable<Employee> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> job = column("job", JDBCType.VARCHAR);

        public final SqlColumn<Integer> salary = column("salary", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> worksSince = column("works_since", JDBCType.TIMESTAMP);

        public Employee() {
            super("employee", Employee::new);
        }
    }
}