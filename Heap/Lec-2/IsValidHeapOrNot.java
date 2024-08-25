class Result {
    boolean isValid;
    int maxValue;

    Result(boolean isValid, int maxValue) {
        this.isValid = isValid;
        this.maxValue = maxValue;
    }
}

public class IsValidHeapOrNot {
    public static Result solve(Node root) {
        // base case
        if (root == null) {
            return new Result(true, Integer.MIN_VALUE);
        }

        if (root.left == null && root.right == null) {
            // leaf node
            return new Result(true, root.data);
        }

        Result leftAns = solve(root.left);
        Result rightAns = solve(root.right);

        if (leftAns.isValid &&
                rightAns.isValid &&
                root.data > leftAns.maxValue &&
                root.data > rightAns.maxValue) {
            return new Result(true, root.data);
        } else {
            return new Result(false, root.data);
        }
    }

    public static boolean isValidHeapTree(Node root) {
        Result ans = solve(root);
        return ans.isValid;
    }

    public static void main(String[] args) {
        int data1[] = { 100, 40, 10, 5, -1, -1, -1, 20, -1, -1, 50, 30, -1, -1, 34, -1, -1, 34, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root = ct1.createTree(data1);
        ct1.bfs(root);
        System.out.println(isValidHeapTree(root));

        int data2[] = { 100, 50, 30, -1, -1, 40, -1, -1, 110, 90, -1, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        ct2.bfs(root2);
        System.out.println(isValidHeapTree(root2));
    }
}
