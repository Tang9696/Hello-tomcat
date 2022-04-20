package by.bsu.helltom.command;

import by.bsu.helltom.dao.OrderDao;
import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Order;
import by.bsu.helltom.entity.Orderitem;
import by.bsu.helltom.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class OrderListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException {

        OrderDao dao = new OrderDao();
        List<Orderitem> Orderitem = dao.findall();
        req.setAttribute("Orderitem",Orderitem);

        return "WEB-INF/view/order-list.jsp";
    }
}
