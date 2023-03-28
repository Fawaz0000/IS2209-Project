package BusinessLogic;

import java.util.List;

public class Product {

    public int id;
    public String name;
    public String description;
    public double price;
    public String image;
    public List<Color> colors;
    public List<Size> sizes;

    public Product(String name, String description, double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Product(int id, String name, String description, double price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Product() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Color> getColors() {
        return this.colors;
    }

    public void setColors(List<Color> list) {
        this.colors = list;
    }

    public List<Size> getSizes() {
        return this.sizes;
    }

    public void setSizes(List<Size> list) {
        this.sizes = list;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product id(int id) {
        this.id = id;
        return this;
    }
}