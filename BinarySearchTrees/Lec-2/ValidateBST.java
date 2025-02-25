public class ValidateBST {
    public static boolean solve(Node root, long lowerBound, long upperBound) {
        // base case
        if (root == null) {
            return true;
        }

        boolean cond1 = (root.data > lowerBound);
        boolean cond2 = (root.data < upperBound);
        boolean leftAns = solve(root.left, lowerBound, root.data);
        boolean rightAns = solve(root.right, root.data, upperBound);

        return cond1 && cond2 && leftAns && rightAns;
    }

    public static boolean isValidBST(Node root) {
        long lowerBound = Long.MIN_VALUE;
        long upperBound = Long.MAX_VALUE;

        boolean ans = solve(root, lowerBound, upperBound);
        return ans;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        Node first = new Node(1);
        Node second = new Node(4);
        Node third = new Node(3);
        Node fourth = new Node(6);
        root1.left = first;
        root1.right = second;
        second.left = third;
        second.right = fourth;

        System.out.println(isValidBST(root1));

        int inOrder[] = { 40, 60, 70, 80, 100, 150, 170, 200, 300, 400 };
        Node root2 = ConstructTree.bstFromInorder(inOrder, 0, inOrder.length - 1);
        System.out.println(isValidBST(root2));
    }
}
