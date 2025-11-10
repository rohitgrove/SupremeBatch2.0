public class FloodFill {
    public static boolean isSafe(int row, int col, int oldColor, int[][] image) {
        return row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == oldColor;
    }

    public static void dfs(int oldColor, int newColor, int[][] image, int sr, int sc, int dx[], int dy[]) {
        image[sr][sc] = newColor;

        for (int i = 0; i < 4; i++) {
            int newRow = sr + dx[i];
            int newCol = sc + dy[i];
            if (isSafe(newRow, newCol, oldColor, image)) {
                dfs(oldColor, newColor, image, newRow, newCol, dx, dy);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int newColor = color;
        // yaha main bhul sacta hu
        if (oldColor == color) {
            return image;
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        dfs(oldColor, newColor, image, sr, sc, dx, dy);
        return image;
    }

    public static void printArr(int arr[][]) {
        for (int[] row : arr) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int image1[][] = { { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 } };
        printArr(floodFill(image1, 1, 1, 2));
        int image2[][] = { { 0, 0, 0 },
                { 0, 0, 0 } };
        printArr(floodFill(image2, 0, 0, 0));
    }
}