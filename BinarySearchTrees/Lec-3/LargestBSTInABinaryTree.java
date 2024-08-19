public class LargestBSTInABinaryTree {
    static class NodeData {
        int size;
        int minVal;
        int maxVal;
        boolean validBST;

        public NodeData() {
        }

        public NodeData(int size, int minVal, int maxVal, boolean validBST) {
            this.size = size;
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.validBST = validBST;
        }
    }

    public static NodeData findLargestBST(Node root, int[] ans) {
        if (root == null) {
            return new NodeData(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        NodeData leftKaAns = findLargestBST(root.left, ans);
        NodeData rightKaAns = findLargestBST(root.right, ans);

        NodeData currNodeKaAns = new NodeData();
        currNodeKaAns.size = leftKaAns.size + rightKaAns.size + 1;
        currNodeKaAns.minVal = Math.min(root.data, leftKaAns.minVal);
        currNodeKaAns.maxVal = Math.max(root.data, rightKaAns.maxVal);

        if (leftKaAns.validBST && rightKaAns.validBST
                && (root.data > leftKaAns.maxVal && root.data < rightKaAns.minVal)) {
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
        int[] ans = new int[1];
        findLargestBST(root, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        Node first = new Node(30);
        Node second = new Node(60);
        Node third = new Node(5);
        Node fourth = new Node(20);
        Node fifth = new Node(45);
        Node sixth = new Node(70);
        Node seventh = new Node(65);
        Node eighth = new Node(80);

        root.left = first;
        root.right = second;
        first.left = third;
        first.right = fourth;
        second.left = fifth;
        second.right = sixth;
        sixth.left = seventh;
        sixth.right = eighth;

        System.out.println("Printing the tree");
        Traversals.levelOrderTraversal(root);

        
        System.out.println("Size of Largest BST: " + largestBst(root));
    }
}
