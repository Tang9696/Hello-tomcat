package by.bsu.helltom.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Category {

    private Integer categoryid;
    private String typename;
    private Integer status;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createtime = formatter.format(date);
    String updatetime = formatter.format(date);

    private List<Product> product;

    public Category() {
    }

    public Category(Integer categoryid, String typename, Integer status, String createtime, String updatetime) {
        this.categoryid = categoryid;
        this.typename = typename;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", typename='" + typename + '\'' +
                ", status=" + status +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
