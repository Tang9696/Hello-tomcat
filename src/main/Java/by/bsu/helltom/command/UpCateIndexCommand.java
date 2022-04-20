package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UpCateIndexCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {

        String categoryid = req.getParameter("id");
        int categoryid_new = Integer.parseInt(categoryid);
        CateDao dao = new CateDao();
        Category category = dao.findbyid(categoryid_new);
        req.setAttribute("category",category);
        return "WEB-INF/view/cate-update.jsp";
    }
}
