package by.bsu.helltom.dao;

import by.bsu.helltom.entity.Category;
import by.bsu.helltom.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CateDao {

    public List<Category> findall() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }

    public Category findbyid(Integer id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from category where categoryid = ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Category> categories = map(resultSet);

        return categories.size() == 1 ? categories.get(0) : null;
    }

    private List<Category> map(ResultSet resultSet) throws SQLException {
        List<Category> categorys = new ArrayList<>();
        while (resultSet.next()){
            Integer categoryid = resultSet.getInt("categoryid");
            String typename = resultSet.getString("typename");
            Integer status = resultSet.getInt("status");
            String createtime = resultSet.getString("createtime");
            String updatetime = resultSet.getString("updatetime");
            Category category = new Category(categoryid,typename,status,createtime,updatetime);
            categorys.add(category);
        }
        return categorys;
    }

    public void addcate(Category category) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sellgoods`.`category` (`categoryid`, `typename`, `status`, `createtime`, `updatetime`) VALUES (?,?,?,?,?);");
        preparedStatement.setInt(1,category.getCategoryid());
        preparedStatement.setString(2,category.getTypename());
        preparedStatement.setInt(3,category.getStatus());
        preparedStatement.setString(4,category.getCreatetime());
        preparedStatement.setString(5,category.getUpdatetime());
        preparedStatement.executeUpdate();
    }

    public void updatecate(int categoryid, String typename, String updatetime) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("update category set typename=?,updatetime=? where categoryid = ?");
        preparedStatement.setString(1,typename);
        preparedStatement.setString(2,updatetime);
        preparedStatement.setInt(3,categoryid);
        preparedStatement.executeUpdate();
    }
}
