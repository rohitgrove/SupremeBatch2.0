import java.util.Scanner;

public class ConstructTree {
    public static Scanner sc = new Scanner(System.in);

    public Node createTree() {
        System.out.println("Enter the value for node: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        // step1: create node
        Node root = new Node(data);
        // step2: Create left subtree
        // System.out.println("Left of Node: "+root.data);
        root.left = createTree();
        // step3: Create right subtree
        // System.out.println("Right of Node: "+root.data);
        root.right = createTree();

        return root;
    }

    private int idx = 0;
    public Node createTree(int[] data) {
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

}
