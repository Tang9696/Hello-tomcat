package by.bsu.helltom.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    private Integer id;
    private Integer cate_proid;
    private String name;
    private String images;
    private String introduce;
    private String price;
    private Integer stock;
    private Integer status;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createtime = formatter.format(date);
    String updatetime = formatter.format(date);

    public Product() {
    }

    public Product(Integer id, Integer cate_proid, String name, String images, String introduce, String price, Integer stock, Integer status, String createtime, String updatetime) {
        this.id = id;
        this.cate_proid = cate_proid;
        this.name = name;
        this.images = images;
        this.introduce = introduce;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCate_proid() {
        return cate_proid;
    }

    public void setCate_proid(Integer cate_proid) {
        this.cate_proid = cate_proid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
