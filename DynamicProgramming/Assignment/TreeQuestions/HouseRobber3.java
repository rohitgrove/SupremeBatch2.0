import java.util.HashMap;

public class HouseRobber3 {
    public static int solveUsingRecursion(Node root) {
        if (root == null) {
            return 0;
        }

        int robThisHouse = 0, dontRobThisHouse = 0;

        // rob current house
        robThisHouse += root.data;
        if (root.left != null) {
            robThisHouse += solveUsingRecursion(root.left.left) + solveUsingRecursion(root.left.right);
        }

        if (root.right != null) {
            robThisHouse += solveUsingRecursion(root.right.left) + solveUsingRecursion(root.right.right);
        }

        // dont rob current house
        dontRobThisHouse += solveUsingRecursion(root.left) + solveUsingRecursion(root.right);
        return Math.max(robThisHouse, dontRobThisHouse);
    }

    public static int solveUsingMemo(Node root, HashMap<Node, Integer> dp) {
        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int robThisHouse = 0, dontRobThisHouse = 0;

        // rob current house
        robThisHouse += root.data;
        if (root.left != null) {
            robThisHouse += solveUsingMemo(root.left.left, dp) + solveUsingMemo(root.left.right, dp);
        }

        if (root.right != null) {
            robThisHouse += solveUsingMemo(root.right.left, dp) + solveUsingMemo(root.right.right, dp);
        }

        // dont rob current house
        dontRobThisHouse += solveUsingMemo(root.left, dp) + solveUsingMemo(root.right, dp);
        dp.put(root, Math.max(robThisHouse, dontRobThisHouse));
        return dp.get(root);
    }

    public static int rob(Node root) {
        // return solveUsingRecursion(root);
        HashMap<Node, Integer> dp = new HashMap<>();
        return solveUsingMemo(root, dp);
    }

    public static void main(String[] args) {
        Node root1 = new Node(3);

        root1.left = new Node(2);
        root1.right = new Node(3);

        root1.left.right = new Node(3);
        root1.right.right = new Node(1);

        System.out.println(rob(root1));

        Node root2 = new Node(3);

        root2.left = new Node(4);
        root2.right = new Node(5);

        root2.left.left = new Node(1);
        root2.left.right = new Node(3);
        root2.right.right = new Node(1);
        System.out.println(rob(root2));
    }
}