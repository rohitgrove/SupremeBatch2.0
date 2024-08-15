public class DiameterOfTree {
    public static int height(Node root) {
        // base case
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
        return Math.max(option1, Math.max(option2, option3));
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root = ConstructTree.createTree(data);
        System.out.println(diameterOfBinaryTree(root));
        int data2[] = { 10, 20, 40, -1, -1, 50, 80, -1, -1, -1, 30, 60, -1, 90, -1, -1, 70, -1, -1 };
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(diameterOfBinaryTree(root2));
    }
}
