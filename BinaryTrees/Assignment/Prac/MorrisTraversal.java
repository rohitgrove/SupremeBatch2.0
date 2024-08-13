import java.util.List;
import java.util.ArrayList;

public class MorrisTraversal {
    public static List<Integer> morrisTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(morrisTraversal(root));
    }
}
