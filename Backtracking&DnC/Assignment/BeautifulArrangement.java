public class BeautifulArrangement {
    static int ans;

    public static void countArrangementHelper(int[] arr, int n, int currNum) {
        // base
        if (currNum == (n + 1)) {
            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0 && (i % currNum == 0 || currNum % i == 0)) {
                arr[i] = currNum;
                countArrangementHelper(arr, n, currNum + 1);
                arr[i] = 0; // backtracking
            }
        }
    }

    public static int countArrangement(int n) {
        int arr[] = new int[n + 1];
        ans = 0;
        countArrangementHelper(arr, n, 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("answer of 2: " + countArrangement(2));
        System.out.println("answer of 1: " + countArrangement(1));
        System.out.println("answer of 3: " + countArrangement(3));
    }
}
