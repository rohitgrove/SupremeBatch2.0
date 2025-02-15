public class DaimeterOfBinaryTree {
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int option1 = diameterOfBinaryTree(root.left);
        int option2 = diameterOfBinaryTree(root.right);
        int option3 = height(root.left) + height(root.right);
        int diameter = Math.max(Math.max(option1, option2), option3);
        return diameter;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root1 = ct.createTree2(data1);
        ct.levelOrderTraversal(root1);
        System.out.println(diameterOfBinaryTree(root1));
        int data2[] = { 10, 11, 20, -1, -1, 12, 60, -1, -1, 80, -1, -1, 15, -1, 40, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree2(data2);
        ct.levelOrderTraversal(root2);
        System.out.println(diameterOfBinaryTree(root2));
    }
}
