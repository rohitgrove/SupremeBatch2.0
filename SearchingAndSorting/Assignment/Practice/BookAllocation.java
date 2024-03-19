public class BookAllocation {
    public static int findPages(int arr[], int N, int M) {
        int sum = 0, s = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int e = sum;

        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (isPossible(arr, N, M, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int arr[], int N, int M, int sol) {
        int sumOfPages = 0;
        int student = 1;
        for (int i = 0; i < N; i++) {
            if (sumOfPages + arr[i] <= sol) {
                sumOfPages += arr[i];
            } else {
                student++;
                if (student > M || arr[i] > sol) {
                    return false;
                }
                sumOfPages = arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 4, arr[] = { 12, 34, 67, 90 }, M = 2;
        System.out.println(findPages(arr, N, M));
    }    
}
