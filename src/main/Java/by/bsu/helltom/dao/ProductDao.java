package by.bsu.helltom.dao;

import by.bsu.helltom.entity.Category;
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
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product a,category b where a.cate_proid =b.categoryid and proid = ?");
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
        //PreparedStatement preparedStatement = connection.prepareStatement("select * from product a");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product a,category b WHERE a.cate_proid =b.categoryid");
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

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sellgoods`.`product` (`proid`,`cate_proid`, `name`, `images`, `introduce`, `price`, `stock`, `status`, `createtime`, `updatetime`) VALUES (null,?, ?, ?, ?, ?, ?, ?, ?, ?)");

        preparedStatement.setInt(1,product.getCate_proid());
        preparedStatement.setString(2,product.getName());
        preparedStatement.setString(3,product.getImages());
        preparedStatement.setString(4,product.getIntroduce());
        preparedStatement.setString(5,product.getPrice());
        preparedStatement.setInt(6,product.getStock());
        preparedStatement.setInt(7,product.getStatus());
        preparedStatement.setString(8, product.getCreatetime());
        preparedStatement.setString(9, product.getUpdatetime());
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
            String introduce = resultSet.getString("introduce");
            String createtime = resultSet.getString("createtime");
            String updatetime = resultSet.getString("updatetime");

            Category category = new Category();
            category.setCategoryid(resultSet.getInt("categoryid"));
            category.setTypename(resultSet.getString("typename"));

            Product product = new Product(id,cate_proid, name,images,introduce,price,stock,status,createtime,updatetime,category);
            products.add(product);
        }
        return products;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("delete from product where proid = ?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    public void updetepro(int id_new, String name, int cate_proid_new, String introduce, Double price, int stock_new, String updatetime) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("update product set cate_proid=?,name=?,introduce=?,price=?,stock=?,updatetime=? where proid = ?");
        preparedStatement.setInt(1,cate_proid_new);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,introduce);
        preparedStatement.setDouble(4,price);
        preparedStatement.setInt(5,stock_new);
        preparedStatement.setString(6,updatetime);
        preparedStatement.setInt(7,id_new);
        preparedStatement.executeUpdate();
    }
}
