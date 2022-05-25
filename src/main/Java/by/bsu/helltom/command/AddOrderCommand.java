package by.bsu.helltom.command;

import by.bsu.helltom.dao.OrderDao;
import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.Order;
import by.bsu.helltom.entity.User;
import by.bsu.helltom.util.RandomUtil;
import org.apache.commons.fileupload.FileUploadException;

import javax.print.attribute.standard.OrientationRequested;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddOrderCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException, FileUploadException {
        String userid = req.getParameter("userid");
        String proid = req.getParameter("proid");
        String price = req.getParameter("price");
        int user_id = Integer.parseInt(userid);
        int pro_id = Integer.parseInt(proid);
        Double price_new = Double.parseDouble(price);
        UserDao userDao = new UserDao();
        User user = userDao.findbyuserid(user_id);

        String ordernumber = "Txkj".concat(RandomUtil.main());
        Order order = new Order();
        String createtime = order.getCreatetime();
        String updatetime = order.getUpdatetime();
        Order order1 = new Order(null,user,ordernumber,price_new,null,null,null,createtime,updatetime);
        OrderDao dao = new OrderDao();
        int oid = dao.addOrder(order1);
        dao.addOrderItem(oid,user_id,pro_id);
        req.setAttribute("message", "Add Order Success");
        req.getRequestDispatcher("controller?command=shoppingpage").forward(req, res);
        return null;
    }
}
