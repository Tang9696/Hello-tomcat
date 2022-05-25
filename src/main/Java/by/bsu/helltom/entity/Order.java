package by.bsu.helltom.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {
    private Integer orderid;
    private User user;
    private String ordernumber;
    private double payment;
    private Integer status;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String paymenttime = formatter.format(date);
    String Cancellationtime = formatter.format(date);
    String createtime = formatter.format(date);
    String updatetime = formatter.format(date);

    private List<Orderitem> orderitem;

    public Order() {
    }

    public Order(Integer orderid, User user, String ordernumber, double payment, Integer status, String paymenttime, String cancellationtime, String createtime, String updatetime) {
        this.orderid = orderid;
        this.user = user;
        this.ordernumber = ordernumber;
        this.payment = payment;
        this.status = status;
        this.paymenttime = paymenttime;
        Cancellationtime = cancellationtime;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", user=" + user +
                ", ordernumber='" + ordernumber + '\'' +
                ", payment=" + payment +
                ", status=" + status +
                ", date=" + date +
                ", formatter=" + formatter +
                ", paymenttime='" + paymenttime + '\'' +
                ", Cancellationtime='" + Cancellationtime + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public String getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(String paymenttime) {
        this.paymenttime = paymenttime;
    }

    public String getCancellationtime() {
        return Cancellationtime;
    }

    public void setCancellationtime(String cancellationtime) {
        Cancellationtime = cancellationtime;
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

    public List<Orderitem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(List<Orderitem> orderitem) {
        this.orderitem = orderitem;
    }
}
