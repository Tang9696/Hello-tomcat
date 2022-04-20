package by.bsu.helltom.command;

import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UpinfoIndexCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException {
        String id = req.getParameter("id");
        Integer userid = Integer.parseInt(id);
        UserDao dao = new UserDao();
        User user = dao.findbyuserid(userid);
        req.setAttribute("user",user);
        return "WEB-INF/view/myinfo-update.jsp";
    }
}
