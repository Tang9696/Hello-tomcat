package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.dao.UserDao;
import by.bsu.helltom.entity.Product;
import by.bsu.helltom.entity.User;
import org.apache.commons.fileupload.RequestContext;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class LoginCommand implements Command {

   // private ServletRequestWrapper ServletActionContext;


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {
        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDao dao = new UserDao();
        User user = dao.login(login,password);
        String name = user.getUsername();
        session.setAttribute("user",user);
        System.out.println("haha");

        if(user.getStatus() == 1) {
            if (user != null && name.equals("admin")) {
                //ProductDao pdao = new ProductDao();
                //List<Product> products = pdao.findAll();
                //req.setAttribute("products", products);
                //HttpServletRequest request = (HttpServletRequest) ServletActionContext.getRequest();
                return "WEB-INF/view/management-page.jsp";
            } else if (user != null && name != "admin") {
                return "controller?command=shoppingpage";
            } else {
                req.setAttribute("error_message", "error username or password");
                return "index.jsp";
            }
        }
        else{
            req.setAttribute("error_message", "user is invalid");
            return "index.jsp";
        }

    }
}
