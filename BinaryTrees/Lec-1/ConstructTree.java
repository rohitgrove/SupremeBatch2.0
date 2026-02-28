import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructTree {
    // it returns root Node of the created tree
    Scanner sc = new Scanner(System.in);

    public Node createTree1() {
        System.out.println("enter the value: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        // step1: create Node
        Node root = new Node(data);
        // Step2: create left subtree
        // System.out.println("left of Node: " + root.data);
        root.left = createTree1();
        // Step3: create right subtree
        // System.out.println("right of Node: " + root.data);
        root.right = createTree1();

        return root;
    }

    int idx = 0;

    public Node createTree2(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        // step1: create Node
        Node root = new Node(data[idx++]);
        // Step2: create left subtree
        // System.out.println("left of Node: " + root.data);
        root.left = createTree2(data);
        // Step3: create right subtree
        // System.out.println("right of Node: " + root.data);
        root.right = createTree2(data);

        return root;
    }

    public void preOrderTraversal(Node root) { // O (n)
        // base case
        if (root == null) {
            return;
        }

        // N L R
        // N
        System.out.print(root.data + " ");
        // L
        preOrderTraversal(root.left);
        // R
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(Node root) { // O (n)
        // LNR
        // base case
        if (root == null) {
            return;
        }

        // L
        inOrderTraversal(root.left);
        // N
        System.out.print(root.data + " ");
        // R
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) { // O (n)
        // LRN
        // Base case
        if (root == null) {
            return;
        }

        // L
        postOrderTraversal(root.left);
        // R
        postOrderTraversal(root.right);
        // N
        System.out.print(root.data + " ");
    }

    public void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        // asli traversal start karte hai

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
    }
}
