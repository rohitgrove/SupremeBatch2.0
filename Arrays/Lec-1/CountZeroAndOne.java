public class CountZeroAndOne {
    public static void countZeroOne(int arr[], int size) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
            if (arr[i] == 1) {
                oneCount++;
            }
        }

        System.out.println("ZeroCount: " + zeroCount);
        System.out.println("oneCOunt: " + oneCount);

    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 };
        // zero => 7
        // one => 8
        int size = arr.length;
        countZeroOne(arr, size);
    }
}
