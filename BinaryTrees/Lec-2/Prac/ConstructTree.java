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

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
