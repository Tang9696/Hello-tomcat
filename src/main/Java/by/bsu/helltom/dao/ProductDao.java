package by.bsu.helltom.dao;

import by.bsu.helltom.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    /**
     * 通过id找数据
     * @param id
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Product findId(int id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product where proid = ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> products = map(resultSet);

        return products.size() == 1 ? products.get(0) : null;

    }

    /**
     * 查找全部
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }
    /**
     * 添加
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void proAdd(Product product) throws ClassNotFoundException, SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sellgoods`.`product` (`proid`, `cate_proid`, `name`, `images`, `introduce`, `price`, `stock`, `status`, `createtime`, `updatetime`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setInt(2,product.getCate_proid());
        preparedStatement.setString(3,product.getName());
        preparedStatement.setString(4,product.getImages());
        preparedStatement.setString(5,product.getIntroduce());
        preparedStatement.setString(6,product.getPrice());
        preparedStatement.setInt(7,product.getStock());
        preparedStatement.setInt(8,product.getStatus());
        preparedStatement.setString(9, product.getCreatetime());
        preparedStatement.setString(10, product.getUpdatetime());
        preparedStatement.executeUpdate();

    }

    private List<Product> map(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("proid");
            Integer cate_proid = resultSet.getInt("cate_proid");
            String name = resultSet.getString("name");
            String images = resultSet.getString("images");
            Integer stock = resultSet.getInt("stock");
            Integer status = resultSet.getInt("status");
            String price = resultSet.getString("price");
            String createtime = resultSet.getString("createtime");
            String updatetime = resultSet.getString("updatetime");
            Product product = new Product(id,cate_proid, name,images,"",price,stock,status,createtime,updatetime);
            products.add(product);
        }
        return products;
    }
}
