public enum Item {

    COKE("Coke", 1.35),PEPSI("Gum", 2.25),SODA("Chocolate", 3.5);
    private String name;
    private double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
