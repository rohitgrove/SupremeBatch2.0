import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(front.data+" ");

                if (front.left != null) {
                    q.add(front.left);
                } 

                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        // int data[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        int data[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        Node root = ConstructTree.createTree(data);
        System.out.println("Pre Order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("In Order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Post Order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("level Order Traversal: ");
        levelOrderTraversal(root);
    }
}
