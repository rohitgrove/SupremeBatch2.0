public class FindFirstOccurrence {
    public static int findFirstOccerence(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 30, 40, 5 };
        System.out.println(findFirstOccerence(arr, 30));
    }
}
