public class SumOfTheLongestBloodLineOfATree {
    public static int[] height(Node root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] lh = height(root.left);
        int[] rh = height(root.right);

        int sum = root.data;
        if (lh[0] == rh[0]) {
            sum += lh[1] > rh[1] ? lh[1] : rh[1];
        } else if (lh[0] > rh[0]) {
            sum += lh[1];
        } else {
            sum += rh[1];
        }
        return new int[] {Math.max(lh[0], rh[0]) + 1, sum};
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        // h {height, sum};
        int h[] = height(root);
        return h[1];
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 4, 2, 7, -1, -1, 1, 6, -1, -1, -1, 5, 2, -1, -1, 3, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(sumOfLongRootToLeafPath(root1));
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(sumOfLongRootToLeafPath(root2));
        int data3[] = { 10, 5, 3, 1, -1, -1, -1, 7, -1, -1, 15, -1, 20, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(sumOfLongRootToLeafPath(root3));
    }
}
