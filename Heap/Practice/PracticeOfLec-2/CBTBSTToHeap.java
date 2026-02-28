import java.util.ArrayList;
import java.util.List;

public class CBTBSTToHeap {
    public static void sotreInorderTraversal(Node root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        sotreInorderTraversal(root.left, inorder);
        inorder.add(root.data);
        sotreInorderTraversal(root.right, inorder);
    }

    public static void replaceUsingPostOrder(Node root, List<Integer> inorder, int[] index) {
        if (root == null) {
            return;
        }

        replaceUsingPostOrder(root.left, inorder, index);
        replaceUsingPostOrder(root.right, inorder, index);
        root.data = inorder.get(index[0]++);
    }

    public static void convertToMaxHeapUtil(Node root) {
        List<Integer> inorder = new ArrayList<>();
        sotreInorderTraversal(root, inorder);
        int index[] = { 0 };
        replaceUsingPostOrder(root, inorder, index);
    }

    public static void main(String[] args) {
        ConstructTreeBST bst = new ConstructTreeBST();
        int data1[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node root1 = bst.bstFromInorder(data1, 0, data1.length - 1);
        Traversals.levelOrder(root1);
        convertToMaxHeapUtil(root1);
        Traversals.levelOrder(root1);
        int data2[] = { 100, 50, 150, 40, 60, 110, 200, 20 };
        Node root2 = bst.createTree(data2);
        Traversals.levelOrder(root2);
        convertToMaxHeapUtil(root2);
        Traversals.levelOrder(root2);
    }
}
