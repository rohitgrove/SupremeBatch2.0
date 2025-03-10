public class CBTIsValidMaxHeapOrNot {
    public static boolean checkMaxHeap(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean leftAns = checkMaxHeap(root.left);
        boolean rightAns = checkMaxHeap(root.right);

        int leftVal = root.left == null ? Integer.MIN_VALUE : root.left.data;
        int rightVal = root.right == null ? Integer.MIN_VALUE : root.right.data;
        return root.data > leftVal && root.data > rightVal && leftAns && rightAns;
    }

    public static boolean isHeap(Node root) {
        return checkMaxHeap(root);
    }

    public static void main(String[] args) {
        ConstructTreeBT ct = new ConstructTreeBT();
        int data1[] = { 100, 40, 10, 5, -1, -1, -1, 20, -1, -1, 50, 30, -1, -1, 34, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(isHeap(root1));

        ct.idx = 0;
        int data2[] = { 97, 46, 12, -1, -1, 3, 2, -1, -1, 4, -1, -1, 37, 7, -1, -1, 31, -1, -1 };
        Node root2 = ct.createTree(data2);
        System.out.println(isHeap(root2));
    }
}