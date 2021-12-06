package com.slums.hands.classloader;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: onehands
 * @description: sth
 * @date: 2021/11/2 11:06
 * @version: 1.0
 */
public class ClassLoaderTest {
    @Test
    public void initData() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8", "root", "mysql_pwd");
        con.setAutoCommit(true);

        String sql = "insert into jar_info (`jar_name`,`jar_content`,`jar_version`,`jar_time`) values (?,?,?,now())";
        PreparedStatement pstInsert = con.prepareStatement(sql);
        pstInsert.setString(1, "first_jar");
        pstInsert.setBlob(2, new FileInputStream(new File("D:\\workspace\\code\\slums\\spi\\target\\spi-0.0.1-SNAPSHOT.jar")));
        pstInsert.setString(3, "v_1.0");
        pstInsert.execute();
    }

    @Test
    public void loadData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8", "root", "mysql_pwd");
        con.setAutoCommit(true);

        ResultSet result = con.createStatement().executeQuery("select * from jar_info");
        byte[] jarContent = null;

        while (result.next()) {
            System.out.println("jar_name:" + result.getString(1));
            jarContent = result.getBytes(2);
            System.out.println("jar_content:" + jarContent.length);
            System.out.println("jar_version:" + result.getString(3));
            System.out.println("jar_time:" + result.getString(4));
        }

        MyClassLoader classLoader = new MyClassLoader(jarContent, this.getClass().getClassLoader());
        Class<?> classz = classLoader.findClass("com.slums.hands.Service");
        System.out.println(classz);
        System.out.println(classz.getClassLoader());
        classz = classLoader.findClass("java.lang.Object");
        System.out.println(classz.getClassLoader());
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this.getClass().getClassLoader().loadClass("java.lang.Object"));
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoaderTest.class.getClassLoader());

    }
}
