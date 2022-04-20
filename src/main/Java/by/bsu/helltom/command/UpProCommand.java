package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UpProCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {

        String id = req.getParameter("id");
        int id_new = Integer.parseInt(id);
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String cate_proid = req.getParameter("cate_proid");
        int cate_proid_new = Integer.parseInt(cate_proid);
        String introduce = new String(req.getParameter("introduce").getBytes("iso-8859-1"), "utf-8");
        String price = req.getParameter("price");
        Double price_new = Double.parseDouble(price);
        String stock = req.getParameter("stock");
        int stock_new = Integer.parseInt(stock);
        Product product = new Product();
        String updatetime = product.getUpdatetime();
        ProductDao dao = new ProductDao();
        dao.updetepro(id_new,name,cate_proid_new,introduce,price_new,stock_new,updatetime);
        req.setAttribute("message", "Update Success");
        req.getRequestDispatcher("controller?command=proList").forward(req, res);
        return null;
    }
}
