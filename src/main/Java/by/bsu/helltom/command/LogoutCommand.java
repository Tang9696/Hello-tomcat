package by.bsu.helltom.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LogoutCommand implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, IOException {
        req.getSession().invalidate();
        return "index.jsp";

    }
}
