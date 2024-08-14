import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class BurningTree {
    public static int amountOfTime(Node root, int start) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node startPtr = bfsToMapParents(root, start, hm);
        return findMinTimeToBurn(startPtr, hm);
    }

    public static Node bfsToMapParents(Node root, int start, HashMap<Node, Node> hm) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        Node startPtr = null;
        while (!qu.isEmpty()) {
            Node curr = qu.poll();
            if (curr.data == start)
                startPtr = curr;
            if (curr.left != null) {
                hm.put(curr.left, curr);
                qu.add(curr.left);
            }
            if (curr.right != null) {
                hm.put(curr.right, curr);
                qu.add(curr.right);
            }
        }
        return startPtr;
    }

    public static int findMinTimeToBurn(Node startPtr, HashMap<Node, Node> hm) {
        HashSet<Node> vis = new HashSet<>();
        Queue<Node> qu = new LinkedList<>();
        qu.add(startPtr);
        vis.add(startPtr);
        int time = 0;
        while (!qu.isEmpty()) {
            boolean flag = false;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curr = qu.poll();
                if (curr.left != null && !vis.contains(curr.left)) {
                    qu.add(curr.left);
                    vis.add(curr.left);
                    flag = true;
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    qu.add(curr.right);
                    vis.add(curr.right);
                    flag = true;
                }
                if (hm.containsKey(curr) && !vis.contains(hm.get(curr))) {
                    qu.add(hm.get(curr));
                    vis.add(hm.get(curr));
                    flag = true;
                }
            }
            if (flag)
                time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int data[] = { 1, 5, -1, 4, 9, -1, -1, 2, -1, -1, 3, 10, -1, -1, 6, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        System.out.println(amountOfTime(root, 3));
    }
}