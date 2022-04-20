package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.entity.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class CateListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException {

        CateDao dao = new CateDao();
        List<Category> categoryList = dao.findall();
        req.setAttribute("category",categoryList);
        return "WEB-INF/view/cate-list.jsp";
    }
}
