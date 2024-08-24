import java.util.Scanner;

public class ConstructBinarySearchTree {
    public static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // it's not the first node
        if (data > root.data) {
            root.right = insertIntoBST(root.right, data);
        } else {
            root.left = insertIntoBST(root.left, data);
        }
        return root;
    }

    public static Node createBST() {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data:");
        int data = sc.nextInt();

        while (data != -1) {
            root = insertIntoBST(root, data);
            System.out.println("Enter data:");
            data = sc.nextInt();
        }
        sc.close();
        return root;
    }

    public static Node createBST(int data[]) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insertIntoBST(root, data[i]);
        }

        return root;
    }

    public static void main(String[] args) {
        int data[] = { 50, 30, 60, 25, 40, 70, 80, 55 };
        Node root = createBST(data);
        InOrderFromStack.inOrderFromStack(root);
    }
}
