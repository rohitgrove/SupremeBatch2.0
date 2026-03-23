import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeBT {
    int idx = 0;

    public Node createTree(int data[]) {
        if (data[idx] == -1) {
            idx++;
            return null;
        }

        // step1: create Node
        Node root = new Node(data[idx++]);
        // Step2: create left subtree
        root.left = createTree(data);
        // Step3: create right subtree
        root.right = createTree(data);

        return root;
    }

    public void levelOrder(Node root) {
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
}