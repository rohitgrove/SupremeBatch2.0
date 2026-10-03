public class SearchInArray {
    public static int search(int arr[], int start, int tar) {
        if (start == arr.length) {
            return -1;
        }

        if (arr[start] == tar) {
            return start;
        }

        return search(arr, start + 1, tar);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        System.out.println(search(arr, 0, 50));
        System.out.println(search(arr, 0, 100));
    }
}
