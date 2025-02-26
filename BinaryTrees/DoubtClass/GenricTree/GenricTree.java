import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenricTree {
    public Node takeInput(Scanner scanner) {
        System.out.print("Enter root data: ");
        int data = scanner.nextInt();
        System.out.print("Enter Children count for " + data + " node: ");
        int count = scanner.nextInt();

        Node root = new Node(data);
        root.childrenCount = count;
        root.children = new Node[count]; // array to store links to children

        for (int i = 0; i < count; i++) {
            root.children[i] = takeInput(scanner);
        }

        return root;
    }

    public void levelOrderPrint(Node root) {
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
                for (int i = 0; i < front.childrenCount; i++) {
                    if (front.children[i] != null) {
                        q.add(front.children[i]);
                    }
                }
            }
        }
    }

}
