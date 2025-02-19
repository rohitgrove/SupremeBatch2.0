import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void rightViewUsingLevelOrder(Node root, List<Integer> ans) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ans.add(q.peek().data);

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                if (!q.isEmpty()) {
                    ans.add(q.peek().data);
                    q.add(null);
                }
            } else {
                if (front.right != null) {
                    q.offer(front.right);
                }

                if (front.left != null) {
                    q.offer(front.left);
                }
            }
        }
    }

    public static void rightViewREC(Node root, int level,List<Integer> ans) {
        if (root == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(root.data);
        }

        rightViewREC(root.right, level + 1, ans);
        rightViewREC(root.left, level + 1, ans);
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightViewUsingLevelOrder(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root1 = ct.crateTree(data1);
        System.out.println(rightView(root1));
        int data2[] = { 10, 7, 9, -1, -1, 8, -1, 5, -1, 4, -1, 2, 3, -1, -1, 1, -1, -1, 6, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.crateTree(data2);
        System.out.println(rightView(root2));
        int data3[] = { 10, 15, 25, -1, 45, 65, -1, -1, 96, -1, -1, -1, 11, 16, -1, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.crateTree(data3);
        System.out.println(rightView(root3));
        int data4[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ct.idx = 0;
        Node root4 = ct.crateTree(data4);
        System.out.println(rightView(root4));
    }
}
