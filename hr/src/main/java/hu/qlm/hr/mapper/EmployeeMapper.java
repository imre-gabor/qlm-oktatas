package hu.qlm.hr.mapper;

import static hu.qlm.hr.mapper.EmployeeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import hu.qlm.hr.model.Employee;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface EmployeeMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8347184+02:00", comments="Source Table: employee")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, job, salary, worksSince);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8257485+02:00", comments="Source Table: employee")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="row.id")
    int insert(InsertStatementProvider<Employee> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8287378+02:00", comments="Source Table: employee")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys=true,keyProperty="records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<Employee> records);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8297349+02:00", comments="Source Table: employee")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="job", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="salary", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="works_since", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8297349+02:00", comments="Source Table: employee")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="job", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="salary", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="works_since", javaType=LocalDateTime.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Optional<Employee> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8307314+02:00", comments="Source Table: employee")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8307314+02:00", comments="Source Table: employee")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8317281+02:00", comments="Source Table: employee")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8317281+02:00", comments="Source Table: employee")
    default int insert(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
            c.map(name).toProperty("name")
            .map(job).toProperty("job")
            .map(salary).toProperty("salary")
            .map(worksSince).toProperty("worksSince")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8327247+02:00", comments="Source Table: employee")
    default int insertMultiple(Collection<Employee> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, employee, c ->
            c.map(name).toProperty("name")
            .map(job).toProperty("job")
            .map(salary).toProperty("salary")
            .map(worksSince).toProperty("worksSince")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8337218+02:00", comments="Source Table: employee")
    default int insertSelective(Employee row) {
        return MyBatis3Utils.insert(this::insert, row, employee, c ->
            c.map(name).toPropertyWhenPresent("name", row::getName)
            .map(job).toPropertyWhenPresent("job", row::getJob)
            .map(salary).toPropertyWhenPresent("salary", row::getSalary)
            .map(worksSince).toPropertyWhenPresent("worksSince", row::getWorksSince)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8357156+02:00", comments="Source Table: employee")
    default Optional<Employee> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8357156+02:00", comments="Source Table: employee")
    default List<Employee> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8367118+02:00", comments="Source Table: employee")
    default List<Employee> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8367118+02:00", comments="Source Table: employee")
    default Optional<Employee> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8377082+02:00", comments="Source Table: employee")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, employee, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8377082+02:00", comments="Source Table: employee")
    static UpdateDSL<UpdateModel> updateAllColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalTo(row::getName)
                .set(job).equalTo(row::getJob)
                .set(salary).equalTo(row::getSalary)
                .set(worksSince).equalTo(row::getWorksSince);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8387048+02:00", comments="Source Table: employee")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Employee row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(name).equalToWhenPresent(row::getName)
                .set(job).equalToWhenPresent(row::getJob)
                .set(salary).equalToWhenPresent(row::getSalary)
                .set(worksSince).equalToWhenPresent(row::getWorksSince);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8397026+02:00", comments="Source Table: employee")
    default int updateByPrimaryKey(Employee row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(job).equalTo(row::getJob)
            .set(salary).equalTo(row::getSalary)
            .set(worksSince).equalTo(row::getWorksSince)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8397026+02:00", comments="Source Table: employee")
    default int updateByPrimaryKeySelective(Employee row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(job).equalToWhenPresent(row::getJob)
            .set(salary).equalToWhenPresent(row::getSalary)
            .set(worksSince).equalToWhenPresent(row::getWorksSince)
            .where(id, isEqualTo(row::getId))
        );
    }
}