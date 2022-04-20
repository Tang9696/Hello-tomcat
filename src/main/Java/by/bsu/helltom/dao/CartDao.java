package by.bsu.helltom.dao;

import by.bsu.helltom.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {

    public List<Cart> findbyid(Integer userid) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select a.`name`,a.price,b.carid,b.createtime,c.userid from product a,cart b,user c where a.proid = b.c_proid and b.c_userid = c.userid and c.userid =?");
        preparedStatement.setInt(1,userid);
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }

    private List<Cart> map(ResultSet resultSet) throws SQLException {
        List<Cart> CartList = new ArrayList<>();
        while (resultSet.next()){
            Integer carid = resultSet.getInt("carid");
            String createtime = resultSet.getString("createtime");

            //获取用户信息
            User user = new User();
            user.setUsername(resultSet.getString("userid"));

            Product product = new Product();
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getString("price"));

            Cart cart = new Cart(carid,createtime,user,product);
            CartList.add(cart);
        }
        return CartList;
    }

}
