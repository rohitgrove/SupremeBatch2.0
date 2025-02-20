import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void printLeftBoundary(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.data);
        if (root.left != null) {
            printLeftBoundary(root.left, ans);
        } else {
            printLeftBoundary(root.right, ans);
        }
    }

    public static void printLeafBoundary(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.data);
        }

        printLeafBoundary(root.left, ans);
        printLeafBoundary(root.right, ans);
    }

    public static void printRightBoundary(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            printRightBoundary(root.right, ans);
        } else {
            printRightBoundary(root.left, ans);
        }
        ans.add(root.data);
    }

    public static List<Integer> traverseBoundary(Node root) {
        List<Integer> ans = new ArrayList<>();
        ans.add(root.data);
        printLeftBoundary(root.left, ans);
        printLeafBoundary(root.left, ans);
        printLeafBoundary(root.right, ans);
        printRightBoundary(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root1 = ct.createTree(data1);
        System.out.println(traverseBoundary(root1));
        int data2[] = { 10, 7, 9, -1, -1, 8, -1, 5, -1, 4, -1, 2, 3, -1, -1, 1, -1, -1, 6, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(traverseBoundary(root2));
        int data3[] = { 10, 15, 25, -1, 45, 65, -1, -1, 96, -1, -1, -1, 11, 16, -1, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(traverseBoundary(root3));
        int data4[] = { 10, 20, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ct.idx = 0;
        Node root4 = ct.createTree(data4);
        System.out.println(traverseBoundary(root4));
        int data5[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ct.idx = 0;
        Node root5 = ct.createTree(data5);
        System.out.println(traverseBoundary(root5));
    }
}
