import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    public static ArrayList<Integer> leftViewUsingBFS(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> leftView = new ArrayList<>();

        q.add(root);
        q.add(null);
        leftView.add(q.peek().data);

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    leftView.add(q.peek().data);
                }
            } else {
                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }

        return leftView;
    }

    public static void leftViewUsingRec(Node root, int level, ArrayList<Integer> leftView) {
        if (root == null) {
            return;
        }

        if (level == leftView.size()) {
            // iska mtlb left view ki node milgayi h, store karlo
            leftView.add(root.data);
        }

        leftViewUsingRec(root.left, level + 1, leftView);
        leftViewUsingRec(root.right, level + 1, leftView);
    }

    public static ArrayList<Integer> leftView(Node root) {
        // return leftViewUsingDFS(root);
        ArrayList<Integer> ans = new ArrayList<>();
        leftViewUsingRec(root, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(arr1);
        ct1.bfs(root1);
        System.out.println(leftView(root1));

        int arr2[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(arr2);
        ct2.bfs(root2);
        System.out.println(leftView(root2));
    }
}
