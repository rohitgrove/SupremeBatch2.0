public class PaintersPartition {
    public static int findLargestMinDistance(int[] boards, int k) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < boards.length; i++) {
            end += boards[i]; 
        }

        int n = boards.length;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (isPossible(boards, n, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] boards, int n, int k, int sol) {
        int coloredBoard = 0;
        int painter = 1;
        for (int i = 0; i < n; i++) {
            if (coloredBoard + boards[i] <= sol) {
                coloredBoard += boards[i];
            } else {
                painter++;
                if (painter > k || boards[i] > sol) {
                    return false;
                }
                coloredBoard = boards[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int boards[] = { 10, 20, 30, 40 };
        int k = 2;
        System.out.println(findLargestMinDistance(boards, k));
    }
}
 