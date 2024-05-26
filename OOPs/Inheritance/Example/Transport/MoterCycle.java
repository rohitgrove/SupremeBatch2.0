package Transport;

public class MoterCycle extends Vehicle {
    public String handleBarStyle;
    public String suspensionType;

    MoterCycle(String name, String model, int noOfTyres, String handleBarStyle, String suspension) {
        super(name, model, noOfTyres);
        this.handleBarStyle = handleBarStyle;
        this.suspensionType = suspension;
    }

    public void wheelie() {
        System.out.println("MotorCycle is doing Whileeeee! " + name);
    }
}
