import java.util.HashMap;

public class LargestSubArraySumZero {
    public static int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int csum = 0;
        int maxLen = 0; // max len if sub Array with 0 sum

        for (int i = 0; i < arr.length; i++) {
            csum += arr[i];
            if (csum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            } else if (!map.containsKey(csum)) {
                map.put(csum, i);
            } else {
                // map has csum already.
                maxLen = Math.max(maxLen, i - map.get(csum));
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr1[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr1));
        int arr2[] = { 2, 10, 4 };
        System.out.println(maxLen(arr2));
        int arr3[] = { 1, 0, -4, 3, 1, 0 };
        System.out.println(maxLen(arr3));
    }
}
