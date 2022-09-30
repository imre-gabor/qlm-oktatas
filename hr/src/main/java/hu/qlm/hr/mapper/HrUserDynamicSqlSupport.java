package hu.qlm.hr.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class HrUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    public static final HrUser hrUser = new HrUser();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source field: hr_user.username")
    public static final SqlColumn<String> username = hrUser.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source field: hr_user.password")
    public static final SqlColumn<String> password = hrUser.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source Table: hr_user")
    public static final class HrUser extends AliasableSqlTable<HrUser> {
        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public HrUser() {
            super("hr_user", HrUser::new);
        }
    }
}