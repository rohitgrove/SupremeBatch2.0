public class FindTarget {
    public static boolean findTarget(int arr[][], int target) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == target) {
                    // if found, return true
                    return true;
                }
            }
        }
        // iss line pr tabhi aa skte ho,
        // jab saare k saare elements check
        // ho chuke honge and target nahi mila hoga
        // return krdo false;
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 1, 11 }
        };
        int target = 110;

        System.out.println("Found or Not: " + findTarget(arr, target));
    }
}
