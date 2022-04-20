package by.bsu.helltom.command;

import by.bsu.helltom.dao.CateDao;
import by.bsu.helltom.entity.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddCateCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException {
        String name = new String(req.getParameter("typename").getBytes("iso-8859-1"), "utf-8");
        int status = 1;
        Category category = new Category();
        String createtime = category.getCreatetime();
        String updatetime = category.getUpdatetime();
        Category category1 = new Category(0,name,status,createtime,updatetime);
        CateDao dao = new CateDao();
        dao.addcate(category1);
        return "controller?command=cateList";
    }
}
