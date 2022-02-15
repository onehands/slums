package com.slums.hands.mysql;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/12/2 17:43
 * @version: 1.0
 */
public class SqlTest {
    @Test
    public void initData() throws ClassNotFoundException, SQLException, FileNotFoundException, UnsupportedEncodingException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8","root","mysql_pwd");
//        Connection con = null;
        con.setAutoCommit(true);
        Statement stmt = con.createStatement();


        String sql = "SELECT cast( NULL AS CHAR CHARACTER SET utf8 ) AS\tname_str UNION ALL SELECT '贝壳找房' AS name_str";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String str = rs.getString(1);
            if (str == null) {
                continue;
            }
            System.out.println(str);
        }

        sql = "SELECT '' AS\tname_str UNION ALL SELECT '贝壳找房' AS name_str";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        PreparedStatement pst = con.prepareStatement("update t_user set name = ?");
        pst.setString(1,"郭富城");
        pst.execute();


    }
}
