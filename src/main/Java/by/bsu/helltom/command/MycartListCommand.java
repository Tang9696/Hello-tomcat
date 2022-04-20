package by.bsu.helltom.command;

import by.bsu.helltom.dao.CartDao;
import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class MycartListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        String id = req.getParameter("userid");
        Integer userid = Integer.parseInt(id);
        CartDao dao = new CartDao();
        List<Cart> cartList = dao.findbyid(userid);
        req.setAttribute("cart",cartList);
        return "WEB-INF/view/mycart-list.jsp";
    }
}
