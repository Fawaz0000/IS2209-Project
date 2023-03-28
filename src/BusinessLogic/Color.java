package BusinessLogic;

public class Color {

    public String color;
    public int prodId;
    public String colorHex;

    public Color(String color, int prodId, String colorHex) {
        this.color = color;
        this.prodId = prodId;
        this.colorHex = colorHex;
    }

    public Color() {
    }
    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProdId() {
        return this.prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getColorHex() {
        return this.colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

}
