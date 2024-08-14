public class MaximumSumOfNonAdjacentNodes {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair getMaxSum_helper(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = getMaxSum_helper(root.left);
        Pair right = getMaxSum_helper(root.right);

        // sum including the node
        int a = root.data + left.second + right.second;

        // sum excluding the node
        int b = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        return new Pair(a, b);
    }

    public static int getMaxSum(Node root) {
        Pair ans = getMaxSum_helper(root);
        return Math.max(ans.first, ans.second);
    }

    public static void main(String[] args) {
        int data1[] = { 1, 2, 1, -1, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(getMaxSum(root1));

        int data2[] = { 1, 2, 4, -1, -1, -1, 3, 5, -1, -1, 6, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(getMaxSum(root2));
    }
}
