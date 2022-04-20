package by.bsu.helltom.command;

import by.bsu.helltom.dao.OrderDao;
import by.bsu.helltom.entity.Orderitem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class MyorderListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        String id = req.getParameter("userid");
        Integer userid = Integer.parseInt(id);
        OrderDao dao = new OrderDao();
        List<Orderitem> orderitemList = dao.findbyuserid(userid);
        System.out.println(orderitemList.get(0));
        req.setAttribute("orderitem",orderitemList);
        return "WEB-INF/view/myorder-list.jsp";
    }
}
