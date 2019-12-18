package model;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int power;

    public Car() {}

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    public Car(int power) {
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return power == car.power &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                '}';
    }
}
