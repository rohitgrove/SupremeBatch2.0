public class ValidTree {
    public static boolean solve(Node root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }

        boolean cond1 = (root.data < upperBound);
        boolean cond2 = (root.data > lowerBound);
        boolean ans1 = solve(root.left, lowerBound, root.data);
        boolean ans2 = solve(root.right, root.data, upperBound);

        return cond1 && cond2 && ans1 && ans2;
    }

    public static boolean isValidBST(Node root) {
        long lowerBound = Long.MIN_VALUE;
        long upperBound = Long.MAX_VALUE;

        boolean ans = solve(root, lowerBound, upperBound);
        return ans;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(4);
        root1.right.left = new Node(3);
        root1.right.right = new Node(6);
        Traversals.levelOrderTraversal(root1);
        System.out.println(isValidBST(root1));

        int data2[] = { 2, 1, 3 };
        Node root2 = ConstructTree.createTree(data2);
        Traversals.levelOrderTraversal(root2);
        System.out.println(isValidBST(root2));

        int data3[] = { 100, 70, 200, 60, 80, 40, 150, 300, 170, 400 };
        Node root3 = ConstructTree.createTree(data3);
        Traversals.levelOrderTraversal(root3);
        System.out.println(isValidBST(root3));
    }
}
