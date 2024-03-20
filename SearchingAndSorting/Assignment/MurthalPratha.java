import java.util.Scanner;

public class MurthalPratha {
    public static int findHowMuchTakeTime(int cook[], int pratha) {
        int start = 0;
        int end = (2 * cook[0] + (pratha - 1) * cook[0]) * pratha / 2;
        
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(cook, pratha, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    public static boolean isPossible(int[] cook, int pratha, int mid) {
        int currP = 0; // initial cooked prata count
        for (int i = 0; i < cook.length; i++) {
            int R = cook[i], j = 1;
            int timeTaken = 0;

            while (true) {
                if ((timeTaken + j * R)  <= mid) {
                    ++currP;
                    timeTaken += j*R;
                    ++j;
                } else {
                    break;
                }
            }

            if (currP >= pratha) {
                return true;
            }
        }

        return false;
    }
    public static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        int nP = sc.nextInt();
        int cP = sc.nextInt();

        int cookRanks[] = new int[cP];
        for (int i = 0; i < cookRanks.length; i++) {
            cookRanks[i] = sc.nextInt();
        }

        System.out.println(findHowMuchTakeTime(cookRanks, nP));
    }
}
