import java.util.HashMap;

public class CheckBSTHasDeadEnd {
    public static void solve(Node root, HashMap<Integer, Boolean> visited, boolean[] ans) {
        if (root == null) {
            return;
        }

        // visit the node
        visited.put(root.data, true);
        if (root.left == null && root.right == null) {
            // Leaf node
            int xp1 = root.data + 1;
            int xm1 = root.data - 1 == 0 ? root.data : root.data - 1;
            if (visited.containsKey(xp1) && visited.containsKey(xm1)) {
                ans[0] = true;
            }

            return;
        }

        solve(root.left, visited, ans);
        solve(root.right, visited, ans);
    }

    public static boolean isDeadEnd(Node root) {
        boolean ans[] = { false }; // tells if then was a DE
        HashMap<Integer, Boolean> visited = new HashMap<>();
        solve(root, visited, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        int data1[] = { 8, 5, 9, 2, 7, 1 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println(isDeadEnd(root1));
        int data2[] = { 8, 7, 10, 2, 9, 13 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(isDeadEnd(root2));
    }
}
