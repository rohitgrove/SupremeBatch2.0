import java.util.Arrays;

public class MaximumHeightByStackingCuboids {
    public static boolean check(int[] curr, int[] prev) {
        // curr -> bade wale dabba
        // prev -> chotte wale dabba
        return prev[0] <= curr[0] && prev[1] <= curr[1] && prev[2] <= curr[2];
    }

    public static int solveUsingTabulationSO(int[][] cuboids) {
        int n = cuboids.length;
        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {
                int include = 0;
                if (prevIndex == -1 || check(cuboids[currIndex], cuboids[prevIndex])) {
                    int heightToAdd = cuboids[currIndex][2];
                    include = heightToAdd + nextRow[currIndex + 1];
                }
                int exclude = nextRow[prevIndex + 1];
                currRow[prevIndex + 1] = Math.max(include, exclude);
            }
            nextRow = Arrays.copyOf(currRow, currRow.length);
        }
        return nextRow[0];
    }

    public static int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> Arrays.compare(a, b));

        return solveUsingTabulationSO(cuboids);
    }

    public static void main(String[] args) {
        int cuboids1[][] = { { 50, 45, 20 }, { 95, 37, 53 }, { 45, 23, 12 } };
        System.out.println(maxHeight(cuboids1));
        int cuboids2[][] = { { 38, 25, 45 }, { 76, 35, 3 } };
        System.out.println(maxHeight(cuboids2));
        int cuboids3[][] = { { 7, 11, 17 }, { 7, 17, 11 }, { 11, 7, 17 }, { 11, 17, 7 }, { 17, 7, 11 }, { 17, 11, 7 } };
        System.out.println(maxHeight(cuboids3));
    }
}
