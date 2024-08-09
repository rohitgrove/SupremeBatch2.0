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

public class BottomView {
    public static ArrayList<Integer> topViewBFS(Node root) {
        TreeMap<Integer, Integer> hdToNodeMap = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> temp = q.poll();
            // baar aya hai ise store karlo
            Node frontNode = temp.first;
            int hd = temp.second;

            // if there is no entry for hd in map, then create a new entry
            hdToNodeMap.put(hd, frontNode.data);

            // Check the left child
            if (frontNode.left != null) {
                q.add(new Pair<>(frontNode.left, hd - 1));
            }
            // Check the right child
            if (frontNode.right != null) {
                q.add(new Pair<>(frontNode.right, hd + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(hdToNodeMap.values());
        return ans;
    }

    public static ArrayList<Integer> topView(Node root) {
        return topViewBFS(root);
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(arr1);
        ct1.bfs(root1);
        System.out.println(topView(root1));

        int arr2[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(arr2);
        ct2.bfs(root2);
        System.out.println(topView(root2));
    }
}
