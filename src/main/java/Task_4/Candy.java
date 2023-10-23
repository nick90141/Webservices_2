package Task_4;

public class Candy {
    private String name;
    private String flavor;
    private double price;

    public Candy() {
    }

    public Candy(String name, String flavor, double price) {
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
