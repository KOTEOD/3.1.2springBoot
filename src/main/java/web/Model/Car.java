package web.Model;

public class Car {
    private String nameCar;
    private String colorCar;
    private String engine;

    public Car(String nameCar, String colorCar, String engine) {
        this.nameCar = nameCar;
        this.colorCar = colorCar;
        this.engine = engine;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameCar='" + nameCar + '\'' +
                ", colorCar='" + colorCar + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }
}
