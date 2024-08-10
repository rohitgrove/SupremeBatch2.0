import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DaignolTraversal {
    public static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> daignol = new ArrayList<>();
        if (root == null) {
            return daignol;
        }

        Queue<Node> q =new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            while (temp != null) {
                daignol.add(temp.data);

                if (temp.left != null) {
                    q.add(temp.left);
                }

                temp = temp.right;
            }
        }

        return daignol;
    }
    public static void main(String[] args) {
        int data[] = { 8, 3, 1, -1, -1, 6, 4, -1, -1, 7, -1, -1, 10, -1, 14, 13, -1, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(diagonal(root));
    }
}