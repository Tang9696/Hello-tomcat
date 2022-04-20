package by.bsu.helltom.dao;

import by.bsu.helltom.entity.Category;
import by.bsu.helltom.entity.Product;
import by.bsu.helltom.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User login(String login , String pwd) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select userid,username,status from user where username=? and password=MD5(?)");
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            return new User(resultSet.getInt("userid"),resultSet.getString("username"), resultSet.getInt("status"));
        }else {

            return null;
        }
    }

    public List<User> findall() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }

    private List<User> map(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            Integer userid = resultSet.getInt("userid");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String phone = resultSet.getString("phone");
            String recevier = resultSet.getString("recevier");
            Integer status = resultSet.getInt("status");
            String createtime = resultSet.getString("createtime");
            String updatetime = resultSet.getString("updatetime");
            User user = new User(userid,username,password,phone,recevier,status,createtime,updatetime);
            users.add(user);
        }
        return users;
    }

    public User findbyuserid(Integer userid) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where userid = ?");
        preparedStatement.setInt(1,userid);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> user = map(resultSet);

        return user.size() == 1 ? user.get(0) : null;
    }

    public void updateinfo(int userid, String username, String phone, String recevier, String updatetime) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("update user set username=?,phone=?,recevier=?,updatetime=? where userid=?");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,phone);
        preparedStatement.setString(3,recevier);
        preparedStatement.setString(4,updatetime);
        preparedStatement.setInt(5,userid);
        preparedStatement.executeUpdate();
    }
}
