import java.util.List;
import java.util.ArrayList;

public class MorrisTraversal {
    public static List<Integer> morrisTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            // left node is null, then visit it and go right
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            } 
            // left node is Not null
            else {
                // find inorder predeccor
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // if pred right node is null, go left after establishing link from pred to curr;
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // left is already visited, Go right after visiting curr node, while removing the link
                    pred.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    
    public static List<Integer> inorderTraversal(Node root) {
        return morrisTraversal(root);
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        ct.bfs(root);
        System.out.println(inorderTraversal(root));
    }
}
