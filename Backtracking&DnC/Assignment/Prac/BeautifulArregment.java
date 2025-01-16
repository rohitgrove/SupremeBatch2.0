public class BeautifulArregment {
    static int ans;

    public static void countArrangementHelper(int arr[], int n, int currNumber) {
        if (currNumber == (n + 1)) {
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0 && (currNumber % i == 0 || i % currNumber == 0)) {
                arr[i] = currNumber;
                countArrangementHelper(arr, n, currNumber + 1);
                arr[i] = 0;
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
