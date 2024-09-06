import java.util.HashMap;

public class LargestSubarraywith0And1 {
    public static int maxLen(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int csum = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            csum += arr[i];
            if (csum == 0) {
                len = Math.max(len, i + 1);
            } else if (!map.containsKey(csum)) {
                map.put(csum, i);
            } else {
                len = Math.max(len, i - map.get(csum));
            }
        }
        
        return len;
    }

    public static void main(String[] args) {
        int A1[] = { 0, 1, 0, 1 };
        System.out.println(maxLen(A1, A1.length));
        int A2[] = { 0, 0, 1, 0, 0 };
        System.out.println(maxLen(A2, A2.length));
    }
}
