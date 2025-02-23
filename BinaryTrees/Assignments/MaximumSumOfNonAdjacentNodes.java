class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class MaximumSumOfNonAdjacentNodes {
    public static Pair getMaxSumHelper(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = getMaxSumHelper(root.left);
        Pair right = getMaxSumHelper(root.right);

        // sum including the node
        int a = root.data + left.second + right.second;

        // sum excluding the node
        int b = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        return new Pair(a, b);
    }

    public static int getMaxSum(Node root) {
        Pair ans = getMaxSumHelper(root);
        return Math.max(ans.first, ans.second);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 1, -1, -1, -1, 3, 4, -1, -1, 5, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(getMaxSum(root1));
        int data2[] = { 1, 2, 4, -1, -1, -1, 3, 5, -1, -1, 6, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(getMaxSum(root2));
    }
}
