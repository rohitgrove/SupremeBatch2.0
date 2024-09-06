import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static int maxLen(int[] arr, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int csum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            csum += arr[i];
            if (csum == 0) {
                len = Math.max(len, i + 1);
            } else if (!hm.containsKey(csum)) {
                hm.put(csum, i);
            } else {
                len = Math.max(len, i - hm.get(csum));
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
