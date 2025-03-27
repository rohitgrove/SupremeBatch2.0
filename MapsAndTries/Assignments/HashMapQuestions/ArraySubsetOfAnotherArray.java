import java.util.HashMap;

public class ArraySubsetOfAnotherArray {
    public static boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // map hashing using a
        for (int i = 0; i < a.length; i++) {
            map.putIfAbsent(a[i], 0);
            map.put(a[i], map.get(a[i]) + 1);
        }

        // check whether all elements of b present in a;
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(b[i])) {
                return false;
            } else {
                // present
                if (map.get(b[i]) > 0) {
                    map.put(b[i], map.get(b[i]) - 1);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int a1[] = { 11, 7, 1, 13, 21, 3, 7, 3 }, b1[] = { 11, 3, 7, 1, 7 };
        System.out.println(isSubset(a1, b1));
        int a2[] = { 1, 2, 3, 4, 4, 5, 6 }, b2[] = { 1, 2, 4 };
        System.out.println(isSubset(a2, b2));
        int a3[] = { 10, 5, 2, 23, 19 }, b3[] = { 19, 5, 3 };
        System.out.println(isSubset(a3, b3));
    }
}