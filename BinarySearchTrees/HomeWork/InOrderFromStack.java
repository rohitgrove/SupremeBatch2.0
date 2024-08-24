import java.util.Stack;

public class InOrderFromStack {
    public static void inOrderFromStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            System.out.print(current.data + " ");

            // Visit the right subtree
            current = current.right;
        }
    }
}