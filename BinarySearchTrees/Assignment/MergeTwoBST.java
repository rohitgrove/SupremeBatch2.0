import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBST {
    public static List<Integer> merge(Node root1, Node root2) {
        List<Integer> ans = new ArrayList<>(); // stores sorted of both the trees;
        Stack<Node> sa = new Stack<>();
        Stack<Node> sb = new Stack<>();

        Node a = root1, b = root2;
        while (a != null || b != null || !sa.isEmpty() || !sb.isEmpty()) {
            while (a != null) {
                sa.push(a);
                a = a.left;
            }            

            while (b != null) {
                sb.push(b);
                b = b.left;
            }

            if (sb.isEmpty() || (!sa.isEmpty() && sa.peek().data <= sb.peek().data)) {
                Node atop = sa.peek();
                ans.add(atop.data);
                sa.pop();
                a = atop.right;   
            } else {
                Node btop = sb.peek();
                ans.add(btop.data);
                sb.pop();
                b = btop.right;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int data1[] = { 5, 3, 6, 2, 4 };
        int data2[] = { 2, 1, 3, 7, 6 };
        Node root1 = ConstructTree.createTree(data1);
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(merge(root1, root2));
    }
}
