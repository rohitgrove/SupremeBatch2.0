import java.util.HashMap;;

public class LargestSubarrayWith0Sum {
    public static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int csum = 0;
        int len = 0; // max length of substring with 0 sum.

        for (int i = 0; i < n; i++) {
            csum += arr[i];
            if (csum == 0) {
                len = Math.max(len, i + 1);
            } else if (!map.containsKey(csum)) {
                map.put(csum, i);
            } else {
                // map has csum already
                len = Math.max(len, i - map.get(csum));
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }, n = arr.length;
        System.out.println(maxLen(arr, n));
        int arr2[] = { 1, 0, -4, 3, 1, 0 }, n2 = arr2.length;
        System.out.println(maxLen(arr2, n2));
    }
}
