public class SearchInArray {
    public static boolean searchArray(int arr[], int target, int index) {
        if (index == arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return searchArray(arr, target, index + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int target = 40;
        System.out.println(searchArray(arr, target, 0));
    }
}
