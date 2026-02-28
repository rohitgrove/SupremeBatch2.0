import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) { // tc: O(NLogN) sc: O(n)
        int stops = 0;
        int dist = 0;
        int i = 0;
        int fuel = startFuel;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]); // {pos, fuel}

        while (true) {
            while (i < stations.length) {
                // push stations within the reach with my currnt levels from my current pos.
                if (stations[i][0] <= dist + fuel) {
                    maxHeap.offer(new int[] { stations[i][0], stations[i][1] });
                } else {
                    break;
                }
                ++i;
            }

            // travel with full fuel level
            dist += fuel;

            // reached
            if (dist >= target) {
                break;
            }

            // no fuel station whithin reach
            if (maxHeap.isEmpty()) {
                stops = -1;
                break;
            }

            // refuel ans re-adjust dist & fuel based on the dist travelled and fuel used till that station
            int[] top = maxHeap.peek();
            fuel = (dist - top[0]) + top[1];
            dist = top[0];
            maxHeap.poll();
            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {
        int target1 = 100, startFuel1 = 10, stations1[][] = { { 10, 60 },
                { 20, 30 },
                { 30, 30 },
                { 60, 40 } };
        System.out.println(minRefuelStops(target1, startFuel1, stations1));
        int target2 = 100, startFuel2 = 1, stations2[][] = { { 10, 100 } };
        System.out.println(minRefuelStops(target2, startFuel2, stations2));
    }
}