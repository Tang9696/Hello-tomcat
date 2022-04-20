package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Category;
import by.bsu.helltom.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class AddProIndexCommand implements Command{



    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        CateDao dao = new CateDao();
        List<Category> category = dao.findall();
        req.setAttribute("category",category);
        return "WEB-INF/view/pro-add.jsp";

    }
}
