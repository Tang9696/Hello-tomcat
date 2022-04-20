package by.bsu.helltom.dao;

import by.bsu.helltom.entity.Order;
import by.bsu.helltom.entity.Orderitem;
import by.bsu.helltom.entity.Product;
import by.bsu.helltom.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Orderitem> findall() throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select b.id,a.ordernumber,a.payment,a.`status`,a.createtime,c.userid,c.username,c.recevier from `order` a, orderitem b,user c where b.o_orderid = a.orderid and b.o_userid = c.userid group by a.ordernumber;");
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }

    public List<Orderitem> findbyuserid(Integer userid) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("select b.id,a.ordernumber,a.payment,a.`status`,a.createtime,c.userid,c.username,c.recevier from `order` a, orderitem b,user c where b.o_orderid = a.orderid and b.o_userid = c.userid and c.userid = ? group by a.ordernumber");
        preparedStatement.setInt(1,userid);
        ResultSet resultSet = preparedStatement.executeQuery();
        return map(resultSet);
    }

    private List<Orderitem> map(ResultSet resultSet) throws SQLException {
        List<Orderitem> OrderitemList = new ArrayList<>();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");

            //获取用户信息
            User user = new User();
            user.setUserid(resultSet.getInt("userid"));
            user.setUsername(resultSet.getString("username"));
            user.setRecevier(resultSet.getString("recevier"));

            Order order = new Order();
            order.setCreatetime(resultSet.getString("createtime"));
            order.setOrdernumber(resultSet.getString("ordernumber"));
            order.setPayment(resultSet.getDouble("payment"));
            order.setStatus(resultSet.getInt("status"));

            Orderitem orderitem = new Orderitem(id,order,user);
            OrderitemList.add(orderitem);
        }
        return OrderitemList;
    }
}
