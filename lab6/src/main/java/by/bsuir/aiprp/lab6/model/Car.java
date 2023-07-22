package by.bsuir.aiprp.lab6.model;

public class Car {
    public static Long count = 0L;
    private Long id;
    private String model;
    private int price;

    public Car() {
    }

    public Car(String model, int price) {
        this.id=++count;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
