package application;

/**
 * Created by Mugen on 5/15/15.
 */
public class Part extends Labor{
    protected String manufacturer;

    public Part(String name, double price, String manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String m) {
        this.manufacturer = m;
    }
}