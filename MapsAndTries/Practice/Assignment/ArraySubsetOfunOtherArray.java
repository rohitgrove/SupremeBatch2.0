import java.util.HashMap;

public class ArraySubsetOfunOtherArray {
    public static String isSubset(long[] a1, long[] a2, int length1, int length2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String ans = "Yes";

        for (int i = 0; i < length1; i++) {
            int count = 0;
            int element = (int)a1[i];
            if (map.containsKey(element)) {
                count = map.get(element);
            }

            map.put(element, count + 1);
        }

        for (int i = 0; i < length2; i++) {
            int element = (int)a2[i];
            if (!map.containsKey(element)) {
                ans = "No";
                break;
            } else {
                int count = map.get(element);
                if (count > 0) {
                    count -= 1;
                    map.put(element, count);
                } else {
                    ans = "No";
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        long a1[] = { 11, 7, 1, 13, 21, 3, 7, 3 },
                a2[] = { 11, 3, 7, 1, 7 };
        System.out.println(isSubset(a1, a2, a1.length, a2.length));
    }
}
