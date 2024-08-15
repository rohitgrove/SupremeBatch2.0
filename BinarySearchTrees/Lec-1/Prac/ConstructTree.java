import java.util.Scanner;

public class ConstructTree {
    public static Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    public static Node createTree() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node root = null;
        while (data != -1) {
            root = insertNode(root, data);
        }

        sc.close();
        return root;
    }

    public static Node createTree(int data[]) {
        Node root = null;
        for (int i = 0; i < data.length; i++) {
            root = insertNode(root, data[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int data[] = { 50, 30, 60, 25, 40, 70, 80, 55 };
        Node root = createTree(data);
        System.out.println("Level Order: ");
        Traversals.levelOrderTraversal(root);
        System.out.printf("PreOreder: ");
        Traversals.preOrder(root);
        System.out.printf("\nPreOreder: ");
        Traversals.inOrder(root);
        System.out.printf("\nPostOreder: ");
        Traversals.postOrder(root);

        System.out.println();
        if (SearchInBST.searchBST(root, 55)) {
            System.out.println("target is found");
        } else {
            System.out.println("target is not found");
        }

        System.out.println("Minimum Node: "+MinimumAndMaximumInBST.minValue(root).data);
        System.out.println("Maximum Node: "+MinimumAndMaximumInBST.maxValue(root).data);

        int key = 80;
        DeleteNodeFromBST.deleteNode(root, key);
        Traversals.levelOrderTraversal(root);
    }
}