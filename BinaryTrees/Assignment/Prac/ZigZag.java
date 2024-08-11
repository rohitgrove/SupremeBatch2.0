import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ZigZag {
    public static void main(String[] args) {
        int[] data = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int width = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                Node front = q.poll();
                if (leftToRight) {
                    level.add(front.data);
                } else {
                    level.add(0, front.data);
                }

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            leftToRight = !leftToRight;
            ans.add(level);
        }

        return ans;
    }
}
