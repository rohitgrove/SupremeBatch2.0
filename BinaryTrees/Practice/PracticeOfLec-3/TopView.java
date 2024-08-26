import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;

class Pair<T, U> {
    public T first;
    public U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

public class TopView {
    public static ArrayList<Integer> topView(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        TreeMap<Integer, Integer> levelToNode = new TreeMap<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> front = q.poll();
            Node currNode = front.first;
            int level = front.second;

            levelToNode.putIfAbsent(level, currNode.data);

            if (currNode.left != null) {
                q.add(new Pair(currNode.left, level - 1));
            }

            if (currNode.right != null) {
                q.add(new Pair(currNode.right, level + 1));
            }
        }
        

        return new ArrayList<>(levelToNode.values());
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
