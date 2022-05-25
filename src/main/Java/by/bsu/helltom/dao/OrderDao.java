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
    public int addOrder(Order order) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        ResultSet rs = null;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sellgoods`.`order` (`orderid`, `ordernumber`, `payment`, `status`, `paymenttime`, `Cancellationtime`, `createtime`, `updatetime`) VALUES (null, ?, ?, 10, null, NULL, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, order.getOrdernumber());
        preparedStatement.setDouble(2, order.getPayment());
        preparedStatement.setString(3, order.getCreatetime());
        preparedStatement.setString(4, order.getUpdatetime());
        preparedStatement.executeUpdate();
        rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            //获取插入数据的Id(主键，自增长)
            int oId = rs.getInt(1);
            // 返回这个Id
            return oId;
        }
        return -1;
    }

    public void addOrderItem(int oid,int uid,int proid) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.ConnectionFactory();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sellgoods`.`orderitem` (`id`, `o_orderid`, `o_userid`, `o_proid`) VALUES (null, ?, ?, ?)");
        preparedStatement.setInt(1,oid);
        preparedStatement.setInt(2,uid);
        preparedStatement.setInt(3,proid);
        preparedStatement.executeUpdate();
    }
}
