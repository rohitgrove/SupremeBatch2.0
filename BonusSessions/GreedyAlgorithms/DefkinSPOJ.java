import java.util.*;

public class DefkinSPOJ {
    public static void defaultInput() {
        int row = 8;
        int col = 15;
        int tower = 3;
        System.out.println(row + " " + col + " " + tower);

        List<int[]> loc = new ArrayList<>();
        loc.add(new int[] { 3, 8 });
        loc.add(new int[] { 11, 2 });
        loc.add(new int[] { 8, 6 });

        List<Integer> xDim = new ArrayList<>();
        xDim.add(0);
        xDim.add(col + 1);
        for (int[] p : loc) {
            xDim.add(p[0]);
        }
        Collections.sort(xDim);

        List<Integer> yDim = new ArrayList<>();
        yDim.add(0);
        yDim.add(row + 1);
        for (int[] p : loc) {
            yDim.add(p[1]);
        }
        Collections.sort(yDim);

        List<Integer> xAns = new ArrayList<>();
        for (int i = 1; i < xDim.size(); i++) {
            int diff = xDim.get(i) - xDim.get(i - 1) - 1;
            xAns.add(diff);
        }

        List<Integer> yAns = new ArrayList<>();
        for (int i = 1; i < yDim.size(); i++) {
            int diff = yDim.get(i) - yDim.get(i - 1) - 1;
            yAns.add(diff);
        }

        int maxi = -1;
        for (int i = 0; i < xAns.size(); i++) {
            for (int j = 0; j < yAns.size(); j++) {
                int prod = xAns.get(i) * yAns.get(j);
                maxi = Math.max(maxi, prod);
            }
        }
        System.out.println("final ANs: " + maxi);
    }

    public static void userInput() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int numTowers = scanner.nextInt();

            List<int[]> loc = new ArrayList<>();
            for (int i = 0; i < numTowers; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                loc.add(new int[] { x, y });
            }

            List<Integer> xDim = new ArrayList<>();
            xDim.add(0);
            xDim.add(width + 1);
            for (int[] p : loc) {
                xDim.add(p[0]);
            }
            Collections.sort(xDim);

            List<Integer> yDim = new ArrayList<>();
            yDim.add(0);
            yDim.add(height + 1);
            for (int[] p : loc) {
                yDim.add(p[1]);
            }
            Collections.sort(yDim);

            List<Integer> xAns = new ArrayList<>();
            for (int i = 1; i < xDim.size(); i++) {
                int diff = xDim.get(i) - xDim.get(i - 1) - 1;
                xAns.add(diff);
            }

            List<Integer> yAns = new ArrayList<>();
            for (int i = 1; i < yDim.size(); i++) {
                int diff = yDim.get(i) - yDim.get(i - 1) - 1;
                yAns.add(diff);
            }

            int maxi = -1;
            for (int i = 0; i < xAns.size(); i++) {
                for (int j = 0; j < yAns.size(); j++) {
                    int prod = xAns.get(i) * yAns.get(j);
                    maxi = Math.max(maxi, prod);
                }
            }

            System.out.println(maxi);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        defaultInput();
    }
}