import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
public class DiagonalTraversal {
    public static void diagonalUsingMap(Node root, TreeMap<Integer, ArrayList<Integer>> map) {
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            Node frontNode = temp.first;
            int hd = temp.second;

            // Add the current node to the corresponding diagonal in the map
            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(frontNode.data);

            // For left child, horizontal distance (hd) remains the same
            if (frontNode.left != null) {
                q.add(new Pair<>(frontNode.left, hd + 1));
            }

            // For right child, horizontal distance (hd) increases by 1
            if (frontNode.right != null) {
                q.add(new Pair<>(frontNode.right, hd));
            }
        }
    }

    public static ArrayList<Integer> diagonal1(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        diagonalUsingMap(root, map);

        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> list : map.values()) {
            result.addAll(list);
        }
        return result;
    }

    public static ArrayList<Integer> diagonal2(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            while (temp != null) {
                ans.add(temp.data);
                if (temp.left != null) {
                    // baad main dhena hai
                    q.add(temp.left);
                }

                temp = temp.right;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int data[] = { 8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 14, 13, -1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(diagonal2(root));
    }
}
