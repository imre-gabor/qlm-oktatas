package hu.qlm.hr.model;

import javax.annotation.Generated;

public class HrUser {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.840699+02:00", comments="Source field: hr_user.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source field: hr_user.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.840699+02:00", comments="Source Table: hr_user")
    public HrUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.840699+02:00", comments="Source Table: hr_user")
    public HrUser() {
        super();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.840699+02:00", comments="Source field: hr_user.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.840699+02:00", comments="Source field: hr_user.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source field: hr_user.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-09-30T10:12:22.8416954+02:00", comments="Source field: hr_user.password")
    public void setPassword(String password) {
        this.password = password;
    }
}