import java.util.ArrayList;
public class EvenNumberInARange {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            for (int j = B.get(i).get(0); j <= B.get(i).get(B.get(i).size() - 1); j++) {
                if (A.get(j) % 2 == 0) {
                    count++;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    public static ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Precompute the number of even numbers up to each index
        ArrayList<Integer> evenCountPrefix = new ArrayList<>();
        int count = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                count++;
            }
            evenCountPrefix.add(count);
        }
        
        // Process each query using the prefix array
        for (ArrayList<Integer> query : B) {
            int left = query.get(0);
            int right = query.get(1);
            
            // Count of even numbers in the range [left, right]
            int evenCountInRange = evenCountPrefix.get(right) - (left > 0 ? evenCountPrefix.get(left - 1) : 0);
            ans.add(evenCountInRange);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>());
        B.get(0).add(0);
        B.get(0).add(2);

        B.add(new ArrayList<>());
        B.get(1).add(2);
        B.get(1).add(4);

        B.add(new ArrayList<>());
        B.get(2).add(1);
        B.get(2).add(4);
        System.out.println(solve2(A, B));

        ArrayList<Integer> C = new ArrayList<>();
        C.add(2);
        C.add(1);
        C.add(8);
        C.add(3);
        C.add(9);
        C.add(6);

        ArrayList<ArrayList<Integer>> D = new ArrayList<>();
        D.add(new ArrayList<>());
        D.get(0).add(0);
        D.get(0).add(3);

        D.add(new ArrayList<>());
        D.get(1).add(3);
        D.get(1).add(5);

        D.add(new ArrayList<>());
        D.get(2).add(1);
        D.get(2).add(3);

        D.add(new ArrayList<>());
        D.get(3).add(2);
        D.get(3).add(4);
        System.out.println(solve2(C, D));
    }
}
