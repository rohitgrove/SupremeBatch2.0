import java.util.LinkedList;
import java.util.Queue;

public class CheckCBT {
    public static boolean levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean nullFound = false;
        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false;
                }

                q.offer(front.left);
                q.offer(front.right);
            }
        }

        return true;
    }

    public static boolean isCompleteTree(Node root) {
        return levelOrderTraversal(root);
    }

    public static void main(String[] args) {
        ConstructTreeBT ct = new ConstructTreeBT();
        int data1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
        Node root1 = ct.createTree(data1);
        Traversals.levelOrder(root1);
        System.out.println(isCompleteTree(root1));
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 7, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        Traversals.levelOrder(root2);
        System.out.println(isCompleteTree(root2));
    }
}
