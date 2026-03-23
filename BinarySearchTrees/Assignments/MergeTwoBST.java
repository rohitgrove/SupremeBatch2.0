import java.util.ArrayList;
import java.util.Stack;

public class MergeTwoBST {
    public static ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> ans = new ArrayList<>(); // stores sorted elements of both the trees;
        Stack<Node> sa = new Stack<>();
        Stack<Node> sb = new Stack<>();

        Node a = root1, b = root2;
        while (a != null || b != null || !sa.isEmpty() || !sb.isEmpty()) {
            while (a != null) {
                sa.push(a);
                a = a.left;
            }

            while (b != null) {
                sb.add(b);
                b = b.left;
            }

            if (sb.isEmpty() || (!sa.isEmpty() && sa.peek().data <= sb.peek().data)) {
                Node atop = sa.pop();
                ans.add(atop.data);
                a = atop.right;
            } else {
                Node btop = sb.pop();
                ans.add(btop.data);
                b = btop.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 5, 3, 6, 2, 4 };
        Node root1 = ConstructTree.createBST(data1);
        int data2[] = { 2, 1, 3, 7, 6 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(merge(root1, root2));
    }
}
