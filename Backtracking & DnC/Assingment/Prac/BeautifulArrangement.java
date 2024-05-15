public class BeautifulArrangement {
    static int ans = 0;
    public static int countArrangement(int n) {
        int[] arr = new int[n + 1];
        countArrangementHelper(n, arr, 1);
        return ans;
    }

    public static void countArrangementHelper(int n, int arr[], int currNum) {
        // base case
        if (currNum == n + 1) {
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0 && (currNum % i == 0 || i % currNum == 0)) {
                arr[i] = currNum;
                countArrangementHelper(n, arr, currNum + 1);
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countArrangement(n));
    }    
}
