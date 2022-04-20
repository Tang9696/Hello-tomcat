package by.bsu.helltom.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    private String recevier;
    private Integer status;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String createtime = formatter.format(date);
    String updatetime = formatter.format(date);

    //用户和商品为

    public User() {
    }

    public User(Integer userid, String username, String password, String phone, String recevier, Integer status, String createtime, String updatetime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.recevier = recevier;
        this.status = status;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public User(Integer userid, String username, Integer status) {
        this.userid = userid;
        this.username = username;
        this.status = status;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", recevier='" + recevier + '\'' +
                ", status=" + status +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
