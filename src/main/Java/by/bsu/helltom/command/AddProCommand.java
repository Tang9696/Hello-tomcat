package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

public class AddProCommand implements Command{



    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, UnsupportedEncodingException {
        String id = req.getParameter("id");
        int id_new = Integer.parseInt(id);
        String cate_proid = req.getParameter("cate_proid");
        int cate_proid_new = Integer.parseInt(cate_proid);
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String images = req.getParameter("images");
        String introduce = new String(req.getParameter("introduce").getBytes("iso-8859-1"), "utf-8");
        String price = req.getParameter("price");
        String stock = req.getParameter("stock");
        int stock_new = Integer.parseInt(stock);
        int status = 1;
        Product product = new Product();
        String createtime = product.getCreatetime();
        String updatetime = product.getUpdatetime();
        System.out.println(id_new + cate_proid_new + name + images + introduce + price + stock_new + status + createtime + updatetime);

        Product product1 = new Product(id_new, cate_proid_new, name, images, introduce, price, stock_new, status, createtime, updatetime);

        ProductDao productDao = new ProductDao();
        productDao.proAdd(product1);
        System.out.println("AddProCommand.execute2");

        return "controller?command=bookList";

    }




}
