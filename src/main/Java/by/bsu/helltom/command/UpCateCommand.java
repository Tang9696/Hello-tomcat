package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UpCateCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {

        String id = req.getParameter("id");
        int categoryid = Integer.parseInt(id);
        String typename = req.getParameter("typename");
        Category category = new Category();
        String updatetime = category.getUpdatetime();
        CateDao dao = new CateDao();
        dao.updatecate(categoryid,typename,updatetime);
        req.setAttribute("message", "Update Success");
        req.getRequestDispatcher("controller?command=cateList").forward(req, res);
        return null;
    }
}
