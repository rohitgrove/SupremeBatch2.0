import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningTree {
    public static int minTime(Node root, int start) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node startPtr = bfsToMapParents(root, start, parentMap);
        return findMinTimeToBurn(startPtr, parentMap);
    }

    public static Node bfsToMapParents(Node root, int start, HashMap<Node, Node> parentMap) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        Node startPtr = null;
        while (!qu.isEmpty()) {
            Node curr = qu.poll();
            if (curr.data == start) {
                startPtr = curr;
            }
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                qu.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                qu.add(curr.right);
            }
        }
        return startPtr;
    }

    public static int findMinTimeToBurn(Node startPtr, HashMap<Node, Node> parentMap) {
        HashSet<Node> vis = new HashSet<>();
        Queue<Node> qu = new LinkedList<>();
        qu.add(startPtr);
        vis.add(startPtr);
        int time = 0;
        while (!qu.isEmpty()) {
            boolean isFiredSpreaded = false;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Node curr = qu.poll();
                if (curr.left != null && !vis.contains(curr.left)) {
                    qu.add(curr.left);
                    vis.add(curr.left);
                    isFiredSpreaded = true;
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    qu.add(curr.right);
                    vis.add(curr.right);
                    isFiredSpreaded = true;
                }
                if (parentMap.containsKey(curr) && !vis.contains(parentMap.get(curr))) {
                    qu.add(parentMap.get(curr));
                    vis.add(parentMap.get(curr));
                    isFiredSpreaded = true;
                }
            }
            if (isFiredSpreaded) {
                time++;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 4, -1, -1, 5, 7, -1, -1, 8, -1, -1, 3, -1, 6, -1, 9, -1, 10, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(minTime(root1, 8));
        int data2[] = { 1, 2, 4, 8, -1, -1, -1, 5, 10, -1, -1, -1, 3, -1, 7, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(minTime(root2, 10));
    }
}
