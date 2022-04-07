package by.bsu.helltom.dao;

import by.bsu.helltom.entity.User;

import java.sql.*;

public class UserDao {
    public User login(String login , String pwd) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select userid,username from user where username=? and password=MD5(?)");
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return new User(resultSet.getInt("userid"),resultSet.getString("username"));
        }else {

            return null;
        }
    }
}
