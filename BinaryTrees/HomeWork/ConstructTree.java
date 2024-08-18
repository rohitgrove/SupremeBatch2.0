import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructTree {
    private Scanner sc = new Scanner(System.in);

    public Node createTree() {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        root.left = createTree();
        root.right = createTree();

        return root;
    }

    private int idx = 0;

    public Node createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        Node root = new Node(data[idx]);
        idx++;

        root.left = createTree(data);
        root.right = createTree(data);

        return root;
    }

    public void bfs(Node root) {
        if (root == null) {
            return;
        }

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
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
    }
}
