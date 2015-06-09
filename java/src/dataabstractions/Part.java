package dataabstractions;

/**
 * @author David Obatake
 */
public class Part extends Labor implements ShopData{
    protected String manufacturer;

    public Part() {}

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
