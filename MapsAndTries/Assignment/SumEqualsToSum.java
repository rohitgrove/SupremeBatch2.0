import java.util.HashMap;

public class SumEqualsToSum {
    public static boolean findPairs(int arr[]) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        // pairs
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    return true;
                } else {
                    map.put(sum, true);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int arr1[] = { 3, 4, 7, 1, 2, 9, 8 };
        System.out.println(findPairs(arr1));
        int arr2[] = { 65, 30, 7, 90, 1, 9, 8 };
        System.out.println(findPairs(arr2));
    } 
}
