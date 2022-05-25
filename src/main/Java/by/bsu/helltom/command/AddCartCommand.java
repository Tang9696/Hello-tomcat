package by.bsu.helltom.command;

import by.bsu.helltom.dao.CartDao;
import by.bsu.helltom.entity.Cart;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddCartCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException, FileUploadException {
        String userid = req.getParameter("userid");
        String proid = req.getParameter("proid");
        int user_id = Integer.parseInt(userid);
        int pro_id = Integer.parseInt(proid);

        Cart cart = new Cart();
        String createtime = cart.getCreatetime();
        String updatetime = cart.getUpdatetime();
        Cart cart1 = new Cart(null,user_id,pro_id,createtime,updatetime);
        CartDao dao = new CartDao();
        dao.cartAdd(cart1);
        req.setAttribute("message", "Add Cart Success");
        req.getRequestDispatcher("controller?command=shoppingpage").forward(req, res);
        return null;
    }
}
