import com.slums.hands.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/10/19 17:56
 * @version: 1.0
 */
@Slf4j
public class JDBCTest {
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8";
    private String jdbcUserName = "root";
    private String jdbcPassword = "mysql_pwd";

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        Connection session = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
        PreparedStatement pst = session.prepareStatement("INSERT INTO t_user (name,age,salary) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        int parameterIndex = 1;
        UserModel userModel = UserModel.builder().name("黎明").age(30).salary(50000D).sex(1).build();
        pst.setString(parameterIndex++, userModel.getName());
        pst.setInt(parameterIndex++, userModel.getAge());
        pst.setDouble(parameterIndex++, userModel.getSalary());
        int count = pst.executeUpdate();
        log.info("影响行数：{}", count);
        ResultSet resultKeys = pst.getGeneratedKeys();
        if (resultKeys != null && resultKeys.next()) {
            log.info("自增值为：{}", resultKeys.getInt(1));
        }
    }
}
