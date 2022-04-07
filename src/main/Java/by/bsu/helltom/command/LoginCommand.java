package by.bsu.helltom.command;

import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(login,password);

        if(user != null){
            req.setAttribute("user",user);
            return "WEB-INF/view/main.jsp";
        }
        else
        {
            req.setAttribute("error_message","error username or password");
            return "index.jsp";
        }

    }
}
