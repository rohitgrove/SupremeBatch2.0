public class Main {
    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        // int data[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        // int data[] = { 10, 20, 50, 65, -1, -1, 90, -1, -1, 70, -1, -1, 30, 60, -1, -1, 110, -1, -1 };
        int data[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        Node root = ct.createTree(data);
        System.out.println(root.data);
        System.out.println();
        System.out.println("PreOrder: ");
        ct.preOrder(root);
        System.out.println();
        System.out.println("Inorder: ");
        ct.inOrder(root);
        System.out.println();
        System.out.println("PostOrder: ");
        ct.postOrder(root);
        System.out.println();
        System.out.println("LevelOrder: ");
        ct.levelOrder(root);
        System.out.println();
    }
}
