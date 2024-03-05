package com.ugurukku.itmtor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbUtil {

    private static final String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/itm-tor";
    private static final String username = "root";
    private static final String password = "root123";

    public static Connection getConnection(){
        try {
            Class.forName(mysqlDriver);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
