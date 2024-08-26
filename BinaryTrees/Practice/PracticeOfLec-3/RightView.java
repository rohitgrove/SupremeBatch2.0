import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class RightView {
    public static ArrayList<Integer> rightViewUsingBFS(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node front = q.poll();

            if (front == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    rightView.add(q.peek().data);
                }
            } else {
                if (front.right != null) {
                    q.add(front.right);
                }

                if (front.left != null) {
                    q.add(front.left);
                }
            }
        }

        return rightView;
    }

    public static void rightViewUsingRec(Node root, int level, ArrayList<Integer> rightView) {
        if (root == null) {
            return;
        }

        if (level == rightView.size()) {
            rightView.add(root.data);
        }

        rightViewUsingRec(root.right, level + 1, rightView);
        rightViewUsingRec(root.left, level + 1, rightView);
    }

    public static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> rightView = new ArrayList<>();
        rightViewUsingRec(root, 0, rightView);
        return rightView;
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 30, 61, -1, -1, 60, 62, -1, -1, -1, 20, 50, -1, 65, -1, 69, -1, -1, 40, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(arr1);
        ct1.bfs(root1);
        System.out.println(rightView(root1));

        int arr2[] = { 10, 20, 40, -1, -1, 50, 70, 110, -1, -1, 111, -1, -1, 80, -1, -1, 30, -1, 60, -1, 90, 112, -1,
                -1, 113, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(arr2);
        ct2.bfs(root2);
        System.out.println(rightView(root2));
    }
}
