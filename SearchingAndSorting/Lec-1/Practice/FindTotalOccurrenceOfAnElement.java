public class FindTotalOccurrenceOfAnElement {
    public static int findLastOccerence(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid = start + (end - start) / 2;
        int ans = -1;

        while (start <= end) {
            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

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

    public static int countFreq(int[] arr, int target) {
        int firstOccur = findFirstOccerence(arr, target);
        int lastOccur = findLastOccerence(arr, target);
        if (firstOccur == -1 && lastOccur == -1) {
            return 0;
        }
        return lastOccur - firstOccur + 1;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(countFreq(arr1, 2));
        int arr2[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(countFreq(arr2, 4));
        int arr3[] = { 8, 9, 10, 12, 12, 12 };
        System.out.println(countFreq(arr3, 12));
    }
}
