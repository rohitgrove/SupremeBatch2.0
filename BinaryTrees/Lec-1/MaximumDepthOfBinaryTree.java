import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }
    public static int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int height = 1;

        while (!q.isEmpty()) {
            Node front = q.poll();

            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                    height++;
                }
            } else {
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }

        return height;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root1 = ConstructTree.createTree(data1);
        System.out.println(maxDepth(root1));
        int data2[] = { 10, 20, 40, -1, -1, 50, 70, -1, -1, 80, -1, -1, 30, -1, 60, -1, -1 };
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(maxDepth(root2));
    }
}
