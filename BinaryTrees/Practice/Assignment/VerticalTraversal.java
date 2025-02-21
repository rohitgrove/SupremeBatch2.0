import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    public Node node;
    public int row;
    public int col;

    public Pair(Node node, int row, int col) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

public class VerticalTraversal {
    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair front = q.poll();
            Node node = front.node;
            int row = front.row;
            int col = front.col;

            mp.putIfAbsent(col, new TreeMap<>());
            mp.get(col).putIfAbsent(row, new PriorityQueue<>());
            mp.get(col).get(row).offer(node.data);

            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : mp.values()) {
            List<Integer> vList = new ArrayList<>();
            for (PriorityQueue<Integer> list : colMap.values()) {
                while (!list.isEmpty()) {
                    vList.add(list.poll());
                }
            }

            ans.add(vList);
        }

        return ans;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(verticalTraversal(root1));
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(verticalTraversal(root2));
        int data3[] = { 1, 2, 4, -1, -1, 6, -1, -1, 3, 5, -1, -1, 7, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(verticalTraversal(root3));
    }
}
