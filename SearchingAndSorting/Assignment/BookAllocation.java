import java.util.Arrays;
public class BookAllocation {
    public static int findPages(int[] Arr, int N, int M) {
        if (M > N) {
            return -1;
        }
        int s = 0;
        int e = Arrays.stream(Arr).sum();

        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (isPossible(Arr, N, M, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int Arr[], int N, int M, int sol) {
        int studentCount = 1;
        int pageSum = 0;
        for (int i = 0; i < N; i++) {
            if (pageSum + Arr[i] <= sol) {
                pageSum += Arr[i];
            } else {
                studentCount++;
                if (studentCount > M || Arr[i] > sol) {
                    return false;
                }
                pageSum = 0;
                pageSum += Arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 4, Arr[] = { 12, 34, 67, 90 }, M = 2;
        System.out.println(findPages(Arr, N, M));
    }
}
