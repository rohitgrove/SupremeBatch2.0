import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class VerticalTraversal {
    static class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair<Node, Pair<Integer, Integer>>> q = new LinkedList<>(); // Node, {row, col}
        q.add(new Pair<>(root, new Pair<>(0, 0)));

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>(); // col -> {row -> [x,y,z....]}

        while (!q.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> front = q.poll();
            Node node = front.first;
            Pair<Integer, Integer> cordinate = front.second;
            int row = cordinate.first;
            int col = cordinate.second;

            mp.putIfAbsent(col, new TreeMap<>());
            mp.get(col).putIfAbsent(row, new PriorityQueue<>());
            mp.get(col).get(row).offer(node.data);

            if (node.left != null) {
                q.add(new Pair<>(node.left, new Pair<>(row + 1, col - 1)));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, new Pair<>(row + 1, col + 1)));
            }
        }

        // Store final vertical order into ans list
        for (Map<Integer, PriorityQueue<Integer>> colMap : mp.values()) {
            List<Integer> vLine = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : colMap.values()) {
                while (!nodes.isEmpty()) {
                    vLine.add(nodes.poll());
                }
            }
            ans.add(vLine);
        }

        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        System.out.println(verticalTraversal(root1));

        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        System.out.println(verticalTraversal(root2));
    }
}
