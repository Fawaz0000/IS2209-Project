package BusinessLogic;

public class Size {

    public String size;
    public int prodId;

    public Size(String size, int prodId) {
        this.size = size;
        this.prodId = prodId;
    }

    public Size(String size){
        this.size = size;
    }

    public Size() {
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
