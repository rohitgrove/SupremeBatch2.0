import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        boolean LtoRdir = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int width = q.size();
            List<Integer> oneLevel = new ArrayList<>();
            for (int i = 0; i < width; i++) {
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

            // toggle the direction
            LtoRdir = !LtoRdir;
            ans.add(oneLevel);
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
