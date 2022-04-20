package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Category;
import by.bsu.helltom.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class UpProIndexCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {

        int id=Integer.parseInt(req.getParameter("id"));
        ProductDao dao = new ProductDao();
        Product product = dao.findId(id);
        req.setAttribute("product",product);
        CateDao dao1 = new CateDao();
        List<Category> category = dao1.findall();
        req.setAttribute("category",category);
        return "WEB-INF/view/pro-update.jsp";
    }
}
