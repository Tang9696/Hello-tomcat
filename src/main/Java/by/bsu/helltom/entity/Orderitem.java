package by.bsu.helltom.entity;

public class Orderitem {

    private Integer id;

    //此表为中间表，为1，所以其他多的一方的实体要在这边创建实体类
    private Order order;
    private User user;
    private Product product;

    public Orderitem(Integer id, Order order, User user, Product product) {
        this.id = id;
        this.order = order;
        this.user = user;
        this.product = product;
    }

    public Orderitem(Integer id, Order order, User user) {
        this.id = id;
        this.order = order;
        this.user = user;
    }

    public Orderitem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        return "Orderitem{" +
                "id=" + id +
                ", order=" + order +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
