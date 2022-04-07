package by.bsu.helltom.dao;

import java.sql.*;

public class ConnectionFactory {

    private  final  static String DRIVER = "com.mysql.jdbc.Driver";
    private  final  static String CONNECTION_STRING = "jdbc:mysql://localhost:3306/sellgoods?useUnicode=true&characterEncoding=utf8";
    private  final  static String USER = "root";
    private  final  static String PASSWORD = "xxxy";
    static {
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection ConnectionFactory() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(CONNECTION_STRING,USER,PASSWORD);
        return connection;
    }
}
