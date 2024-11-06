public class FindMinimumAnswer {
    public static int findMinimumInArray(int arr[], int size) {
        // ans store variable
        int minAns = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] < minAns) {
                minAns = arr[i];
            }
        }

        return minAns;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 8, 31, 4, 3, 1, -51 };
        int size = arr.length;

        int minimum = findMinimumInArray(arr, size);
        System.out.println("Minimum number is: " + minimum);
    }
}
