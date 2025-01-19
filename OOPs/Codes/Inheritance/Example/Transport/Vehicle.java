package Transport;

public class Vehicle {
    public String name;
    public String model;
    public int noOftyres;

    public Vehicle() {
        this.name = "";
        this.model = "";
        this.noOftyres = -1;
    }

    public Vehicle(String name, String model, int noOftyres) {
        this.name = name;
        this.model = model;
        this.noOftyres = noOftyres;
    }

    public void startEngine() {
        System.out.printf("Engine is starting of %s : %s\n", name, model);
    }

    public void stopEngine() {
        System.out.printf("Engine is stoping of %s : %s\n", name, model);
    }
}
