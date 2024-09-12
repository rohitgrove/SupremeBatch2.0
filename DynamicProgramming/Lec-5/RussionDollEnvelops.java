import java.util.Arrays;

public class RussionDollEnvelops {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1]; 
        });

        return solveUsingTabulationSO(envelopes);
    }

    public static boolean check(int[] curr, int[] prev) {
        // curr -> larger env
        // prev -> smaller env
        if (prev[0] < curr[0] && prev[1] < curr[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static int solveUsingTabulationSO(int[][] env) {
        int n = env.length;

        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        // Loop over the cuboids in reverse order
        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {
                int include = 0;
                // If prevIndex is -1 or the prev cuboid can fit into the current cuboid
                if (prevIndex == -1 || check(env[currIndex], env[prevIndex])) {
                    include = 1 + nextRow[currIndex + 1];
                }

                int exclude = 0 + nextRow[prevIndex + 1];
                currRow[prevIndex + 1] = Math.max(include, exclude);
            }
            // Shift rows
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static void main(String[] args) {
        int envelopes[][] = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println(maxEnvelopes(envelopes));
    }
}
