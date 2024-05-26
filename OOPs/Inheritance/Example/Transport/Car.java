package Transport;

public class Car extends Vehicle {
    public int noOfDoors;
    public String transmission;

    Car(String name, String model, int noOfTyres, int noOfDoors, String transmissionType) {
        super(name, model, noOfTyres);
        this.noOfDoors = noOfDoors;
        this.transmission = transmissionType;
    }

    public void startAc() {
        System.out.println("AC Started of " + name);
    }
}
