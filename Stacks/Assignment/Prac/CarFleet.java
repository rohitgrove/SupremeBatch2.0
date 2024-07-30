import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {
    static class Car {
        int position, speed;
        public Car( int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }

    static class CustomComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.position - o2.position;
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(position[i], speed[i]);
            cars.add(car);
        }

        Collections.sort(cars, new CustomComparator());
    
        Stack<Float> st = new Stack<>();
        for (int i = 0; i < cars.size(); i++) {
            float time = (target - cars.get(i).position) / ((float) cars.get(i).speed);
            while (!st.empty() && time >= st.peek()) {
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
