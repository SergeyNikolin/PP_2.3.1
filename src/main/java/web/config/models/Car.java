package web.config.models;


public class Car {

    private String name;
    private String color;
    private int series;


    public Car() {

    }

    public Car(String name, String color, int series) {
        this.name = name;
        this.color = color;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
