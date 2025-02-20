import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftSideView {
    public static void leftViewFromLevelOrder(Node root, List<Integer> leftView) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        leftView.add(q.peek().data);

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                if (!q.isEmpty()) {
                    leftView.add(q.peek().data);
                    q.offer(null);
                }
            } else {
                if (front.left != null) {
                    q.offer(front.left);
                }

                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }
    }

    public static void leftViewREC(Node root, int level, List<Integer> leftView) {
        if (root == null) {
            return;
        }

        if (level == leftView.size()) {
            // iska mtlb left veiw ki node milgyi h, store karlo
            leftView.add(root.data);
        }

        leftViewREC(root.left, level + 1, leftView);
        leftViewREC(root.right, level + 1, leftView);
    }

    public static List<Integer> leftView(Node root) {
        List<Integer> leftView = new ArrayList<>();
        leftViewREC(root, 0, leftView);
        return leftView;
    }

    public static void main(String[] args) {
        int data1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root1 = ct.createTree(data1);
        System.out.println(leftView(root1));
        int data2[] = { 10, 7, 9, -1, -1, 8, -1, 5, -1, 4, -1, 2, 3, -1, -1, 1, -1, -1, 6, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(leftView(root2));
        int data3[] = { 10, 15, 25, -1, 45, 65, -1, -1, 96, -1, -1, -1, 11, 16, -1, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(leftView(root3));
        int data4[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ct.idx = 0;
        Node root4 = ct.createTree(data4);
        System.out.println(leftView(root4));
    }
}
