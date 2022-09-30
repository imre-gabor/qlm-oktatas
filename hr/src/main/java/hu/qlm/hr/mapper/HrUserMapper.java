package hu.qlm.hr.mapper;

import static hu.qlm.hr.mapper.HrUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import hu.qlm.hr.model.HrUser;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface HrUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<HrUser>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    BasicColumn[] selectList = BasicColumn.columnList(username, password);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<HrUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ConstructorArgs({
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Optional<HrUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    default int deleteByPrimaryKey(String username_) {
        return delete(c -> 
            c.where(username, isEqualTo(username_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    default int insert(HrUser row) {
        return MyBatis3Utils.insert(this::insert, row, hrUser, c ->
            c.map(username).toProperty("username")
            .map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default int insertMultiple(Collection<HrUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, hrUser, c ->
            c.map(username).toProperty("username")
            .map(password).toProperty("password")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default int insertSelective(HrUser row) {
        return MyBatis3Utils.insert(this::insert, row, hrUser, c ->
            c.map(username).toPropertyWhenPresent("username", row::getUsername)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default Optional<HrUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default List<HrUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default List<HrUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default Optional<HrUser> selectByPrimaryKey(String username_) {
        return selectOne(c ->
            c.where(username, isEqualTo(username_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, hrUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    static UpdateDSL<UpdateModel> updateAllColumns(HrUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalTo(row::getUsername)
                .set(password).equalTo(row::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(HrUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(username).equalToWhenPresent(row::getUsername)
                .set(password).equalToWhenPresent(row::getPassword);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default int updateByPrimaryKey(HrUser row) {
        return update(c ->
            c.set(password).equalTo(row::getPassword)
            .where(username, isEqualTo(row::getUsername))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8426918+02:00", comments="Source Table: hr_user")
    default int updateByPrimaryKeySelective(HrUser row) {
        return update(c ->
            c.set(password).equalToWhenPresent(row::getPassword)
            .where(username, isEqualTo(row::getUsername))
        );
    }
}