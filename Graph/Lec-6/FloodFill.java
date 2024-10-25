public class FloodFill {
    public static boolean isSafe(int newRow, int newCol, int oldColor, int[][] image) {
        return (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
                && image[newRow][newCol] == oldColor);
    }

    public static void dfs(int oldColor, int newColor, int[][] image, int sr, int sc, int direction[][]) {
        image[sr][sc] = newColor;
       
        for (int dir[] : direction) {
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];
            if (isSafe(newRow, newCol, oldColor, image)) {
                dfs(oldColor, newColor, image, newRow, newCol, direction);
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

        int direction[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        dfs(oldColor, newColor, image, sr, sc, direction);
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
        int image1[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, sr1 = 1, sc1 = 1, color1 = 2;
        printArr(floodFill(image1, sr1, sc1, color1));

        int image2[][] = { { 0, 0, 0 }, { 0, 0, 0 } }, sr2 = 0, sc2 = 0, color2 = 0;
        printArr(floodFill(image2, sr2, sc2, color2));
    }
}