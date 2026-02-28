public class CBTIsValidMaxHeapOrNot {
    public static Info checkMaxHeap1(Node root) {
        if (root == null) {
            Info temp = new Info(Integer.MIN_VALUE, true);
            return temp;
        }

        if (root.left == null && root.right == null) {
            Info temp = new Info(root.data, true);
            return temp;
        }

        Info leftAns = checkMaxHeap1(root.left);
        Info rightAns = checkMaxHeap1(root.right);
        // 1 case mujhe solve karna h

        if (root.data > leftAns.maxValue && root.data > rightAns.maxValue && leftAns.isHeap && rightAns.isHeap) {
            Info ans = new Info(root.data, true);
            return ans;
        } else {
            Info ans = new Info(Math.max(root.data, Math.max(leftAns.maxValue, rightAns.maxValue)), false);
            return ans;
        }
    }

    public static boolean checkMaxHeap2(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        boolean leftAns = checkMaxHeap2(root.left);
        boolean rightAns = checkMaxHeap2(root.right);

        int leftValue = root.left == null ? Integer.MIN_VALUE : root.left.data;
        int rightValue = root.right == null ? Integer.MIN_VALUE : root.right.data;
        return root.data > leftValue && root.data > rightValue && leftAns && rightAns;
    }

    public static boolean isHeap(Node root) {
        return checkMaxHeap2(root);
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
