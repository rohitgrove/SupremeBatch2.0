public class FloodFill {
    public static boolean isSafe(int[][] image, int row, int col, int newColor, int oldColor) {
        return (row >= 0 && row < image.length && col >= 0 && col < image.length && image[row][col] == oldColor);
    }

    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] direction) {
        image[sr][sc] = newColor;

        for (int[] dir : direction) {
            int row = sr + dir[0];
            int col = sc + dir[1];
            if (isSafe(image, row, col, newColor, oldColor)) {
                dfs(image, row, col, newColor, oldColor, direction);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int newColor = color;
        if (oldColor == newColor) {
            return image;
        }

        int direction[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        dfs(image, sr, sc, newColor, oldColor, direction);

        return image;
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int image1[][] = { { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } }, sr1 = 1, sc1 = 1, color1 = 2;
        printArr(floodFill(image1, sr1, sc1, color1));

        int image2[][] = { { 0, 0, 0 },
                { 0, 0, 0 } }, sr2 = 0, sc2 = 0, color2 = 0;
        printArr(floodFill(image2, sr2, sc2, color2));
    }
}