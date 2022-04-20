package by.bsu.helltom.command;

import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, IOException, ServletException, FileUploadException;
}
