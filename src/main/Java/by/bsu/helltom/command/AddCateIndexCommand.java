package by.bsu.helltom.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddCateIndexCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException {

        return "WEB-INF/view/cate-add.jsp";
    }
}
