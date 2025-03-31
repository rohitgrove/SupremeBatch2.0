import java.util.Arrays;

public class RussianDoll {
    public static boolean check(int[] curr, int[] prev) {
        // curr -> bade wale dabba
        // prev -> chotte wale dabba
        return prev[0] < curr[0] && prev[1] < curr[1];
    }

    public static int solveUsingTabulationSO(int[][] envelopes) {
        int n = envelopes.length;
        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {
                int include = 0;
                if (prevIndex == -1 || check(envelopes[currIndex], envelopes[prevIndex])) {
                    include = 1 + nextRow[currIndex + 1];
                }
                int exclude = nextRow[prevIndex + 1];
                currRow[prevIndex + 1] = Math.max(include, exclude);
            }
            nextRow = Arrays.copyOf(currRow, currRow.length);
        }
        return nextRow[0];
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int ans = solveUsingTabulationSO(envelopes);
        return ans;
    }

    public static void main(String[] args) {
        int envelopes[][] = { { 5, 4 },
                { 6, 4 },
                { 6, 7 },
                { 2, 3 } };

        System.out.println(maxEnvelopes(envelopes));
    }
}
