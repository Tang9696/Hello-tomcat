package by.bsu.helltom.command;

import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UpinfoCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        String id = req.getParameter("id");
        int userid = Integer.parseInt(id);
        System.out.println(userid);
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String recevier = req.getParameter("recevier");
        User user = new User();
        String updatetime = user.getUpdatetime();
        UserDao dao = new UserDao();
        dao.updateinfo(userid,username,phone,recevier,updatetime);
        req.setAttribute("message", "Update Success");
        req.getRequestDispatcher("controller?command=logout").forward(req, res);
        return null;
    }
}
