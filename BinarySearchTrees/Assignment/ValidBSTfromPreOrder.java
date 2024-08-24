import java.util.ArrayList;

public class ValidBSTfromPreOrder {
    static int idx = 0;

    public static void build(int min, int max, ArrayList<Integer> A) {
        if (idx >= A.size()) {
            return;
        }

        if (A.get(idx) > min && A.get(idx) < max) {
            int rootData = A.get(idx++);
            build(min, rootData, A);
            build(rootData, max, A);
        }
    }

    public static int solve(ArrayList<Integer> A) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        build(min, max, A);
        if (idx == A.size()) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(7);
        A.add(7);
        A.add(10);
        A.add(10);
        A.add(9);
        A.add(5);
        A.add(2);
        A.add(8);
        System.out.println(solve(A));
    }
}
