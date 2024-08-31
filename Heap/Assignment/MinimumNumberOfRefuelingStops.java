import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    public int fuel;
    public int pos;

    public Pair(int fuel, int pos) {
        this.fuel = fuel;
        this.pos = pos;
    }
}

class CustomComp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.fuel - o1.fuel;
    }
}

public class MinimumNumberOfRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int dist = 0;
        int i = 0;
        int fuel = startFuel;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComp()); // {fuel, pos}
        while (true) {
            while (i < stations.length) {
                // push station within the reach the with my current fuel levels from my current
                // pos.
                if (stations[i][0] <= dist + fuel) {
                    pq.add(new Pair(stations[i][1], stations[i][0]));
                } else {
                    break;
                }
                ++i;
            }

            // travel with full fuel level
            dist += fuel;
            fuel = 0;

            // reached
            if (dist >= target) {
                break;
            }

            // no fuel stations within reach
            if (pq.isEmpty()) {
                stops = -1;
                break;
            }

            // refuel ans re-adjust dist & fuel based on the dist travelled and fuel used
            // till that station
            Pair top = pq.peek();
            fuel = (dist - top.pos) + top.fuel;
            dist = top.pos;
            pq.poll();
            ++stops;
        }

        return stops;
    }

    public static void main(String[] args) {
        int target1 = 1, startFuel1 = 1, stations1[][] = {};
        System.out.println(minRefuelStops(target1, startFuel1, stations1));
        int target2 = 100, startFuel2 = 1, stations2[][] = { { 10, 100 } };
        System.out.println(minRefuelStops(target2, startFuel2, stations2));
        int target3 = 100, startFuel3 = 10, stations3[][] = { { 10, 60 },
                { 20, 30 },
                { 30, 30 },
                { 60, 40 } };
        System.out.println(minRefuelStops(target3, startFuel3, stations3));
    }
}
