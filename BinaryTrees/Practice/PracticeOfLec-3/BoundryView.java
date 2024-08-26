import java.util.ArrayList;

public class BoundryView {
    public static void leftBoundary(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        res.add(root.data);
        if (root.left != null) {
            leftBoundary(root.left, res);
        } else {
            leftBoundary(root.right, res);
        }
    }

    public static void leafNode(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(root.data);
        }

        leafNode(root.left, res);
        leafNode(root.right, res);
    }

    public static void rightBoundary(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, res);
        } else {
            rightBoundary(root.left, res);
        }

        res.add(root.data);
    }

    public static ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> boundary = new ArrayList<>();
        boundary.add(root.data);
        leftBoundary(root.left, boundary);
        leafNode(root.left, boundary);
        leafNode(root.right, boundary);
        rightBoundary(root.right, boundary);
        return boundary;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(arr);
        ct.bfs(root);
        System.out.println(boundary(root));
    }
}
