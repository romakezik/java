package by.bsuir.aiprp.lab6.contr;

import by.bsuir.aiprp.lab6.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarManager {
    private static final List<Car> carList;

    static {
        Car car1 = new Car();
        car1.setId((long) 1);
        car1.setModel("SL 500");
        car1.setPrice(20000);

        Car car2 = new Car();
        car2.setId((long) 2);
        car2.setModel("607");
        car2.setPrice(35000);

        Car car3 = new Car();
        car3.setId((long) 3);
        car3.setModel("KIA");
        car3.setPrice(15000);

        Car car4 = new Car();
        car4.setId((long) 4);
        car4.setModel("Toyota");
        car4.setPrice(25000);

        carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        Car.count = 4L;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Optional<Car> findByModel(String model) {
        return carList.stream()
                .filter(car -> car.getModel().equals(model))
                .findFirst();
    }

    public List<Car> cheaperThan(int price) {
        return carList.stream()
                .filter(car -> car.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public void addNewCar(String model, int price) {
        carList.add(new Car(model, price));
    }
}
