import java.util.HashMap;

public class FirstReapeatingElement {
    public static int firstRepeated1(int[] arr, int n) {// tc: O(n2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    public static int firstRepeated2(int[] arr, int n) {// tc: O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) > 1) {
                return i + 1;
            }
        }

        return -1;
    }

    public static int firstRepeated3(int[] arr, int n) {// tc: O(n)
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];
        for (int i = 0; i < count.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[arr[i]] > 1) {
                return count[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 4, 3, 5, 6 };
        System.out.println(firstRepeated3(arr, arr.length));
    }
}
