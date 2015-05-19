package application.dataabstractions;

/**
 * @author David Obatake
 */
public class Labor {
    protected String name;
    protected double price;

    public Labor() {

        // @TODO Need to prompt user for name and price somehow..
        this.name = "";
        this.price = 0.0;
    }

    public Labor(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
