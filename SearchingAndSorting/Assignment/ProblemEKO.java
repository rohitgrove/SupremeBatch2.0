import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemEKO {
    public static boolean isPossible(ArrayList<Long> trees, long m, long mid) {
        long woodCollected = 0;
        for (long tree : trees) {
            if (tree > mid) {
                woodCollected += tree - mid;
            }
        }
        return woodCollected >= m;
    }

    public static long maxSawBladeHeight(ArrayList<Long> trees, long m) {
        long start = 0;
        long end = Collections.max(trees);
        long ans = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossible(trees, m, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = 7;
        ArrayList<Long> trees = new ArrayList<>();
        trees.add((long) 20);
        trees.add((long) 15);
        trees.add((long) 10);
        trees.add((long) 17);

        long maxSawBladeHeight = maxSawBladeHeight(trees, m);
        System.out.println(maxSawBladeHeight);
        scanner.close();
    }
}
