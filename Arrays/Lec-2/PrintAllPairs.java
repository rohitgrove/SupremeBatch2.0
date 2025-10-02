public class PrintAllPairs {
    public static void printAllPairs(int arr[], int size) {
        // outer loop
        for (int i = 0; i < size; i++) {
            // inner loop
            for (int j = 0; j < size; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    public static void printAllTriplets(int arr[], int size) {
        // outer loop
        for (int i = 0; i < size; i++) {
            // inner loop
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30 };
        int size = arr.length;
        printAllPairs(arr, size);
        printAllTriplets(arr, size);
    }
}
