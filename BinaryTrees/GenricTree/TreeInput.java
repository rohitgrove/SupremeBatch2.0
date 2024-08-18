import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeInput {
    public static Node takeInput(Scanner scanner) {
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

    public static void levelOrderPrint(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Using 'null' as a marker for the end of a level

        while (!q.isEmpty()) {
            Node front = q.poll(); // Retrieve and remove the head of the queue

            if (front == null) {
                // End of a level
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null); // Add marker for the next level
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = takeInput(scanner);
        levelOrderPrint(root);
    }
}
