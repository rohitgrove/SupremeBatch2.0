import java.util.*;

public class DEFKIN {
    public static void main(String[] args) {
        int row = 8;
        int col = 15;
        int tower = 3;

        System.out.println(row + " " + col + " " + tower);

        int[][] loc = { { 3, 8 }, { 11, 2 }, { 8, 6 } };

        int[] xDim = new int[loc.length + 2];
        xDim[0] = 0;
        xDim[1] = col + 1;
        for (int i = 0; i < loc.length; i++) {
            xDim[i + 2] = loc[i][0];
        }
        Arrays.sort(xDim);

        int[] yDim = new int[loc.length + 2];
        yDim[0] = 0;
        yDim[1] = row + 1;
        for (int i = 0; i < loc.length; i++) {
            yDim[i + 2] = loc[i][1];
        }
        Arrays.sort(yDim);

        int[] xAns = new int[xDim.length - 1];
        for (int i = 1; i < xDim.length; i++) {
            xAns[i - 1] = xDim[i] - xDim[i - 1] - 1;
        }

        int[] yAns = new int[yDim.length - 1];
        for (int i = 1; i < yDim.length; i++) {
            yAns[i - 1] = yDim[i] - yDim[i - 1] - 1;
        }

        int maxi = -1;
        for (int x : xAns) {
            for (int y : yAns) {
                int prod = x * y;
                maxi = Math.max(maxi, prod);
            }
        }
        System.out.println("Final Ans: " + maxi);
    }
}
