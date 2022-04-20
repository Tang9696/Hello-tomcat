package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class DelProCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(req.getParameter("id"));
        ProductDao dao = new ProductDao();
        dao.delete(id);
        req.setAttribute("message", "Delete Success");
        req.getRequestDispatcher("controller?command=proList").forward(req, res);
        return null;
    }
}
