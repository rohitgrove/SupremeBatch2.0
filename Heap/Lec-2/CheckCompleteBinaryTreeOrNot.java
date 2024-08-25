import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTreeOrNot {
    public static boolean levelOrderTraversal(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            Node front = q.poll();

            if (front == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false;
                }
                q.add(front.left);
                q.add(front.right);
            }
        }
        return true;
    }

    public static boolean isCompleteTree(Node root) {
        return levelOrderTraversal(root);
    }

    public static void main(String[] args) {
        int data1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(isCompleteTree(root1));

        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 7, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(isCompleteTree(root2));
    }
}
