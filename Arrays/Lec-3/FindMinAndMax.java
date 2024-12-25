public class FindMinAndMax {
    public static int findMax(int arr[][]) {
        int maxAns = Integer.MIN_VALUE;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] > maxAns) {
                    maxAns = arr[i][j];
                }
            }
        }
        return maxAns;
    }

    public static int findMin(int arr[][]) {
        int minAns = Integer.MAX_VALUE;
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] < minAns) {
                    minAns = arr[i][j];
                }
            }
        }
        return minAns;
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 70, 8 },
                { 9, 10, 1, 11 },
                { 12, 24, 46, 89 }
        };
        System.out.println(findMin(arr));
        System.out.println(findMax(arr));
    }
}
