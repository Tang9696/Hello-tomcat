package by.bsu.helltom;

import by.bsu.helltom.command.Command;
import by.bsu.helltom.command.CommandFactory;
import by.bsu.helltom.command.LoginCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        process(req,resp);

    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        process(req,resp);
    }

    public void process(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory factory = new CommandFactory();
        String commandParam = req.getParameter("command");
        Command command = factory.create(commandParam);
        try {
            String page = command.execute(req,resp);
            req.getRequestDispatcher(page).forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
