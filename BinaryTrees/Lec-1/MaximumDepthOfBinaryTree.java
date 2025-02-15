import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static int maxDepthUsingRec(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepthUsingRec(root.left);
        int rightHeight = maxDepthUsingRec(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public static int maxDepthUsingLevelOrder(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count = 1;

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                if (!q.isEmpty()) {
                    count++;
                    q.offer(null);
                }
            } else {
                if (front.left != null) {
                    q.offer(front.left);
                }

                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }

        return count;
    }

    public static int maxDepth(Node root) {
        return maxDepthUsingLevelOrder(root);
    }

    public static void main(String[] args) {
        int data[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree2(data);
        ct.levelOrderTraversal(root);
        System.out.println(maxDepth(root));
    }
}
