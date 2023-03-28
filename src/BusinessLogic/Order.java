package BusinessLogic;

import java.sql.Timestamp;

public class Order {

    public int id;
    public User user;
    public Product product;
    public int quantity;
    public double price;
    public Color color;
    public Size size;
    public Timestamp date;
    
    public Order(int id, User user, Product product, int quantity, double price, Color color, Size size) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.size = size;
    }

    public Order() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setColor(String color) {
        this.color = new Color(color);
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Order id(int id) {
        this.id = id;
        return this;
    }

    public String toCsv() {
        return this.id + "," + this.user.getEmail() + "," + this.product.getId() + "," + this.quantity + "," + this.price + "," + this.color.getColor() + "," + this.size.getSize();
    }

}