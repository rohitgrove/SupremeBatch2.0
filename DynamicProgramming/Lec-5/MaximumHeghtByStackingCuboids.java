import java.util.Arrays;

public class MaximumHeghtByStackingCuboids {
    // Check if the "prev" cuboid can fit inside the "curr" cuboid
    public static boolean check(int[] curr, int[] prev) {
        // curr -> larger cuboid
        // prev -> smaller cuboid
        if (prev[0] <= curr[0] && prev[1] <= curr[1] && prev[2] <= curr[2]) {
            return true;
        } else {
            return false;
        }
    }

    public static int solveUsingTabulationSO(int[][] cuboids) {
        int n = cuboids.length;

        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        // Loop over the cuboids in reverse order
        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {

                int include = 0;
                // If prevIndex is -1 or the prev cuboid can fit into the current cuboid
                if (prevIndex == -1 || check(cuboids[currIndex], cuboids[prevIndex])) {
                    int heightToAdd = cuboids[currIndex][2];
                    include = heightToAdd + nextRow[currIndex + 1];
                }

                int exclude = 0 + nextRow[prevIndex + 1];
                currRow[prevIndex + 1] = Math.max(include, exclude);
            }
            // Shift rows
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int maxHeight(int[][] cuboids) {
        // Sort each cuboid so that dimensions are in non-decreasing order
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        // Sort cuboids to process them in a sorted order
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        return solveUsingTabulationSO(cuboids);
    }

    public static void main(String[] args) {
        int cuboids1[][] = { { 50, 45, 20 },
                { 95, 37, 53 },
                { 45, 23, 12 } };
        System.out.println(maxHeight(cuboids1));
        int cuboids2[][] = { { 38, 25, 45 },
                { 76, 35, 3 } };
        System.out.println(maxHeight(cuboids2));
        int cuboids3[][] = { { 7, 11, 17 },
                { 7, 17, 11 },
                { 11, 7, 17 },
                { 11, 17, 7 },
                { 17, 7, 11 },
                { 17, 11, 7 } };
        System.out.println(maxHeight(cuboids3));
    }
}
