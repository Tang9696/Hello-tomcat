package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class ShoppingListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        ProductDao dao = new ProductDao();
        List<Product> products = dao.findAll();
        req.setAttribute("products",products);

        return "WEB-INF/view/shopping-page.jsp";
    }
}
