import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Car cars[] = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(position[i], speed[i]);
            cars[i] = car;
        }

        Arrays.sort(cars, new Compare());

        Stack<Float> st = new Stack<>();
        for (Car car : cars) {
            float time = (target - car.pos) / ((float) car.speed);
            while (!st.isEmpty() && time >= st.peek()) {
                st.pop();
            }
            st.push(time);
        }

        return st.size();
    }

    public static void main(String[] args) {
        int target1 = 12, position1[] = { 10, 8, 0, 5, 3 }, speed1[] = { 2, 4, 1, 1, 3 };
        System.out.println(carFleet(target1, position1, speed1));
        int target2 = 100, position2[] = { 0, 2, 4 }, speed2[] = { 4, 2, 1 };
        System.out.println(carFleet(target2, position2, speed2));
    }
}
