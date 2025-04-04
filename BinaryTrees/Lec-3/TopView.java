import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    public Node node;
    public int hd;

    public Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {
    public static List<Integer> topView(Node root) {
        TreeMap<Integer, Integer> hdToNodeMap = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            // Agar iss horizontal Distance ke liye answer abhi tak store nhi hua hai toh abb store karlo
            Node frontNode = temp.node;
            int hd = temp.hd;
            // if there is no entry for hd in map, then create a new entry
            hdToNodeMap.putIfAbsent(hd, frontNode.data);

            // child ko dekhna h
            if (frontNode.left != null) {
                q.offer(new Pair(frontNode.left, hd - 1));
            }

            if (frontNode.right != null) {
                q.offer(new Pair(frontNode.right, hd + 1));
            }
        }

        return new ArrayList<>(hdToNodeMap.values());
    }

    public static void main(String[] args) {
        int data1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root1 = ct.createTree(data1);
        System.out.println(topView(root1));
        int data2[] = { 10, 7, 9, -1, -1, 8, -1, 5, -1, 4, -1, 2, 3, -1, -1, 1, -1, -1, 6, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(topView(root2));
        int data3[] = { 10, 15, 25, -1, 45, 65, -1, -1, 96, -1, -1, -1, 11, 16, -1, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(topView(root3));
        int data4[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ct.idx = 0;
        Node root4 = ct.createTree(data4);
        System.out.println(topView(root4));
    }
}
