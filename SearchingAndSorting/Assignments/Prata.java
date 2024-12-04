public class Prata {
    public static boolean isPossible(int[] rank, int nP, int mid) {
        int currP = 0; // initial cooked Prata Count
        for (int i = 0; i < rank.length; i++) {
            int R = rank[i], j = 1;
            int timeTaken = 0;
            while (true) {
                if (timeTaken + j * R <= mid) {
                    currP++;
                    timeTaken += j*R;
                    j++;
                } else {
                    break;
                }
            }

            if (currP >= nP) {
                return true;
            }
        }

        return false;
    }

    public static int minCookTime(int rank[], int nP) {
        int start = 0;
        int highestRank = 0;
        for (int i = 0; i < rank.length; i++) {
            highestRank = Math.max(highestRank, rank[i]);
        }
        int end = highestRank * (nP * (nP + 1) / 2);
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(rank, nP, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int rank1[] = { 1, 2, 3, 4 };
        System.out.println(minCookTime(rank1, 11));
        System.out.println(minCookTime(rank1, 10));
        int rank2[] = { 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(minCookTime(rank2, 8));
    }
}
