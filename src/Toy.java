public class Toy {
    private int id;
    private String toyName;
    private int quantity; // количество игрушек
    private double frequency; // частота выпадения игрушки

    public Toy(int id, String toyName, int quantity, double frequency) {
        this.id = id;
        this.toyName = toyName;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Имя игрушки: " + toyName + ", количество: " + quantity + ", шанс выпадения: " +
                frequency + "%" + ", id: " + id;

    }
}


