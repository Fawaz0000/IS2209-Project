package BusinessLogic;

public class Product {

    public int id;
    public String name;
    public String description;
    public double price;
    public Color[] colors;
    public Size[] sizes;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public Color[] getColors() {
        return this.colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public Size[] getSizes() {
        return this.sizes;
    }

    public void setSizes(Size[] sizes) {
        this.sizes = sizes;
    }

    public String toCsv() {
        return this.id + "," + this.name + "," + this.description + "," + this.price;
    }
    
}