import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(root);

        boolean LtoRdir = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> oneLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node front = q.poll();
                if (LtoRdir) {
                    oneLevel.add(front.data);
                } else {
                    oneLevel.add(0, front.data);
                }

                if (front.left != null) {
                    q.offer(front.left);
                }

                if (front.right != null) {
                    q.offer(front.right);
                }
            }

            ans.add(oneLevel);
            LtoRdir = !LtoRdir;
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root = ct.createTree(data);
        System.out.println(zigzagLevelOrder(root));
    }
}
