package by.bsu.helltom.command;

import by.bsu.helltom.dao.ProductDao;
import by.bsu.helltom.entity.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddProCommand implements Command{



    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException, IOException, FileUploadException {


        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取上传路径
        String path = req.getSession().getServletContext().getRealPath("/images");
        System.out.println(path);
        File file = new File(path);
        String filename = null;
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(path + "目录不存在，需要创建");
            // 创建目录
            file.mkdir();
        }else{
            System.out.println("存在目录");
            System.out.println(path);
        }

        //先将文件放置于临时存储空间里
        //最终通过流的形式将文件写到瓷盘里
        factory.setRepository(new File(path));
        //设置文件大小
        factory.setSizeThreshold(1024*1024);

        //使用api进行文件上传处理
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        //处理多文件上传
        OutputStream os = null;
        InputStream in = null;

        List<FileItem> list = upload.parseRequest(req);
        Map<String,String> map=new HashMap<>();

        for(FileItem item : list){
            String name1 = item.getFieldName();

            if(item.isFormField()){
                String value = item.getString("UTF-8");
                //System.out.println(name1 + "=" + value);
                map.put(name1,value);

            }else {
                //处理非文本类型数据类似图片,pdf,rar等等
                //分三步走
                //1.获取路径名
                String value = item.getName();
                //d:\\test\\hehe.jgp
                //2.处理反斜杠
                int start = value.lastIndexOf("\\");
                //得到文件名，去除反斜杠前面的内容
                //String images = req.getParameter("images");
                filename = value.substring(start + 1);

                map.put("image","images"+"/"+filename);
                //3.准备写入
                //上传需要读写流
                os = new FileOutputStream(new File(path, filename));

                in = item.getInputStream();

                int length = 0;
                byte[] buf = new byte[1024];
                while ((length = in.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }

                in.close();
                os.close();
            }
            }

        String image = map.get("image");
        String name = map.get("name");
        String cate_proid = map.get("cate_proid");
        int cate_proid_new = Integer.parseInt(cate_proid);
        String introduce = map.get("introduce");
        String price = map.get("price");
        String stock = map.get("stock");
        int stock_new = Integer.parseInt(stock);
        int status = 1;
        Product product = new Product();
        String createtime = product.getCreatetime();
        String updatetime = product.getUpdatetime();
        //System.out.println(cate_proid_new + name + image + introduce + price + stock_new + status + createtime + updatetime);
        ProductDao productDao = new ProductDao();
        Product product1 = new Product(null,cate_proid_new,name,image,introduce,price,stock_new,status,createtime,updatetime);
        productDao.proAdd(product1);
        System.out.println("AddProCommand.execute2");
        return "controller?command=proList";
    }



}
