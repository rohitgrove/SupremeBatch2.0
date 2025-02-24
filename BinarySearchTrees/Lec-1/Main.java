public class Main {
    public static void main(String[] args) {
        // int data[] = { 50, 30, 20, 25, 40, 60, 70, 80, 55 };
        // int data[] = { 50, 30, 60, 25, 40, 70, 80, 55 };
        // int data[] = { 100, 50, 30, 20, 40, 200, 150, 175, 300, 400 };
        int data[] = { 100, 50, 30, 90, 70, 95, 200, 300, 400 };
        Node root = ConstructTree.createBST(data);
        System.out.println("Level Oreder");
        Traversals.levelOrder(root);
        System.out.printf("\nInOrder: ");
        Traversals.inOrder(root);
        System.out.printf("\npreOrder: ");
        Traversals.preOrder(root);
        System.out.printf("\nPostOrder: ");
        Traversals.postOrder(root);

        System.out.println();
        Node minNode = MinAndMaxValue.minValue(root);
        if (minNode == null) {
            System.out.println("There is no node in tree, so no min value");
        } else {
            System.out.println("Min value: " + minNode.data);
        }

        Node maxNode = MinAndMaxValue.maxValue(root);
        if (maxNode == null) {
            System.out.println("There is no node in tree, so no max value");
        } else {
            System.out.println("Max value: " + maxNode.data);
        }

        int t = 80;
        if (SearchInBST.search(root, t)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        Traversals.levelOrder(DeleteNodeFromBST.deleteNode(root, 300));
    }
}
