package Transport;

public class Vehicle {
    protected String name;
    public String model;
    public int noOfTyres;

    public Vehicle() {
        this.name = "";
        this.model = "";
        this.noOfTyres = -1;
    }
    
    Vehicle(String name, String model, int noOfTyres) {
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
    }

    void startEngine() {
        System.out.printf("Engine is Starting of %s : %s\n", name, model);
    }

    void stopEngine() {
        System.out.printf("Engine is Stoping of %s : %s\n", name, model);
    }
}