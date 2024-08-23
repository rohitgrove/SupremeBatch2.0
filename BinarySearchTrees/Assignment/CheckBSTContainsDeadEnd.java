import java.util.HashMap;

public class CheckBSTContainsDeadEnd {
    public static boolean solve(Node root, HashMap<Integer, Boolean> visited) {
        if (root == null) {
            return false;
        }

        // visit the node
        visited.put(root.data, true);
        if (root.left == null && root.right == null) {
            // leaf node
            int xp1 = root.data + 1;
            int xm1 = root.data - 1 == 0 ? root.data : root.data - 1;
            if (visited.containsKey(xp1) && visited.containsKey(xm1)) {
                return true;
            }
            return false;
        }

        return solve(root.left, visited) ||
        solve(root.right, visited);
    }

    public static boolean isDeadEnd(Node root) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        return solve(root, visited);
    }

    public static void main(String[] args) {
        int data1[] = { 8, 5, 9, 2, 7, 1 };
        Node root1 = ConstructTree.createTree(data1);
        System.out.println(isDeadEnd(root1));

        int data2[] = { 8, 7, 10, 2, 9, 13 };
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(isDeadEnd(root2));
    }
}
