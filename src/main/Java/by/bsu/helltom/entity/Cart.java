package by.bsu.helltom.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cart {
    private Integer carid;
    private Integer c_userid;
    private Integer c_proid;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createtime = formatter.format(date);
    String updatetime = formatter.format(date);

    private User user;
    private Product product;

    public Cart() {
    }

    public Cart(Integer carid, Integer c_userid, Integer c_proid, String createtime, String updatetime, User user, Product product) {
        this.carid = carid;
        this.c_userid = c_userid;
        this.c_proid = c_proid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.user = user;
        this.product = product;
    }

    public Cart(Integer carid,String createtime, User user, Product product) {
        this.carid = carid;
        this.createtime = createtime;
        this.user = user;
        this.product = product;
    }

    public Cart(Integer carid, Integer c_userid, Integer c_proid, String createtime, String updatetime) {
        this.carid = carid;
        this.c_userid = c_userid;
        this.c_proid = c_proid;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getC_userid() {
        return c_userid;
    }

    public void setC_userid(Integer c_userid) {
        this.c_userid = c_userid;
    }

    public Integer getC_proid() {
        return c_proid;
    }

    public void setC_proid(Integer c_proid) {
        this.c_proid = c_proid;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "carid=" + carid +
                ", c_userid=" + c_userid +
                ", c_proid=" + c_proid +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
