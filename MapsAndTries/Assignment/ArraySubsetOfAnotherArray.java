import java.util.HashMap;

public class ArraySubsetOfAnotherArray {
    public static String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String ans = "Yes";

        // map hashing using at
        for (int i = 0; i < n; i++) {
            int count = 0;
            int element = (int)a1[i];
            if (map.containsKey(element)) {
                count = map.get(element);
            }
            map.put(element, count + 1);
        }
        
        // check whether all ements at a2 presnt in a1
        for (int i = 0; i < m; i++) {
            int element = (int)a2[i];
            if (!map.containsKey(element)) {
                ans = "No";
                break;
            } else {
                // present
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
