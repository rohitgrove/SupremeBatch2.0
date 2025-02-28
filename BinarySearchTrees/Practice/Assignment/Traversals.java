import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    public static void preOrder(Node root) {
        // NLR
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        // LNR
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        // LRN
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node front = q.poll();

            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(front.data + " ");

                if (front.left != null) {
                    q.offer(front.left);
                }

                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }

        System.out.println();
    }

    public static void morrisTraversal(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }

        System.out.println();
    }
}
