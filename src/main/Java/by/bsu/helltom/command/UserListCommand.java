package by.bsu.helltom.command;

import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class UserListCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException {
        UserDao dao = new UserDao();
        List<User> users = dao.findall();
        req.setAttribute("users",users);
        return "WEB-INF/view/user-list.jsp";
    }
}
