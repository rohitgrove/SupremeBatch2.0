class NodeData {
    int size;
    int minVal;
    int maxVal;
    boolean validBST;

    public NodeData() {
    }

    public NodeData(int size, int max, int min, boolean valid) {
        this.size = size;
        this.minVal = min;
        this.maxVal = max;
        this.validBST = valid;
    }
}

public class LargestBSTInABT {
    static NodeData findLargestBST(Node root, int[] ans) {
        // base case
        if (root == null) {
            return new NodeData(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        NodeData leftKaAns = findLargestBST(root.left, ans);
        NodeData rightKaAns = findLargestBST(root.right, ans);

        // checking starts here
        NodeData currNodeKaAns = new NodeData();

        currNodeKaAns.size = leftKaAns.size + rightKaAns.size + 1;
        currNodeKaAns.maxVal = Math.max(root.data, rightKaAns.maxVal);
        currNodeKaAns.minVal = Math.min(root.data, leftKaAns.minVal);

        if (leftKaAns.validBST && rightKaAns.validBST && (root.data > leftKaAns.maxVal && root.data < rightKaAns.minVal)) {
            currNodeKaAns.validBST = true;
        } else {
            currNodeKaAns.validBST = false;
        }

        if (currNodeKaAns.validBST) {
            ans[0] = Math.max(ans[0], currNodeKaAns.size);
        }
        return currNodeKaAns;
    }

    public static int largestBst(Node root) {
        int ans[] = new int[1];
        findLargestBST(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        ConstructBinaryTree ct = new ConstructBinaryTree();
        int data1[] = { 5, 2, 1, -1, -1, 3, -1, -1, 4, -1, -1 };
        Node root1 = ct.createTree(data1);
        Traversals.levelOrder(root1);
        System.out.println(largestBst(root1));
        int data2[] = { 6, 7, -1, 2, -1, -1, 3, 2, -1, -1, 4, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        Traversals.levelOrder(root2);
        System.out.println(largestBst(root2));
        int data3[] = { 50, 30, 5, -1, -1, 20, -1, -1, 60, 45, -1, -1, 70, 65, -1, -1, 80, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        Traversals.levelOrder(root3);
        System.out.println(largestBst(root3));
    }
}
