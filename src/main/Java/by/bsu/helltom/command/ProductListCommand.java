package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ProductListCommand implements Command{

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {

        ProductDao dao = new ProductDao();
        List<Product> products = dao.findAll();
        req.setAttribute("products",products);

        return "WEB-INF/view/pro-list.jsp";
    }
}
