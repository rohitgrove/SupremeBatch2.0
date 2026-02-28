package Transport;

public class Main {
    public static void main(String[] args) {
        Car c = new Car("maruti", "800", 4, 5, "Automatic");
        c.startEngine();
        c.startAC();
        c.stopEngine();
        System.out.println(c.name);

        // MotorCycle m = new MotorCycle("Seplander", "Xline", 2, "U", "Soft");
        // m.startEngine();
        // m.wheelie();
        // m.stopEngine();
    }
}
