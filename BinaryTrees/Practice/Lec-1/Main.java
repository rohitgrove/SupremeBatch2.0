public class Main {
    public static void main(String[] args) {
        // int data[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        // int data[] = { 10, 20, 50, 65, -1, -1, 90, -1, -1, 70, -1, -1, 30, 60, -1, -1, 110, -1, -1 };
        int data[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        // int data[] = { 10, 20, 30, 40, -1, -1, -1, 15, -1, -1, 55, 25, -1, -1, 45, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        System.out.print("preOrder: ");
        ct.preOrder(root);
        System.out.println();
        System.out.print("InOrder: ");
        ct.inOrder(root);
        System.out.println();
        System.out.print("PostOrder: ");
        ct.postOrder(root);
        System.out.println();
        System.out.println("LevelOrder: ");
        ct.levelOrder(root);
    }
}
