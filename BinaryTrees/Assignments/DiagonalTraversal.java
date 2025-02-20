import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {
    public static void solveREC(Node root, TreeMap<Integer, List<Integer>> map, int d) {
        if (root == null) {
            return;
        }

        if (map.containsKey(d)) {
            map.get(d).add(root.data);
        } else {
            map.put(d, new ArrayList<>());
            map.get(d).add(root.data);
        }

        solveREC(root.left, map, d + 1);
        solveREC(root.right, map, d);
    }

    public static ArrayList<Integer> diagonal1(Node root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        solveREC(root, map, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            for (int ele : map.get(i)) {
                ans.add(ele);
            }
        }

        return ans;
    }

    public static ArrayList<Integer> diagonal2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            while (temp != null) {
                ans.add(temp.data);
                if (temp.left != null) {
                    // baad main dekhenge
                    q.offer(temp.left);
                }
                temp = temp.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data[] = { 8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 14, 13, -1, -1, -1 };
        Node root = ct.createTree(data);
        System.out.println(diagonal2(root));
    }
}
