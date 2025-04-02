import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static List<Integer> morrisTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            // left node is null, then, visit it and go right
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            }
            // left node is NOT NULL
            else {
                // find inorder predecesoor
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null) {
                    pred = pred.right;
                }

                // if pred right is Null, then go left after establishing link from pred to curr;
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

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 10, 20, 40, 80, -1, -1, 90, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, 110, -1, -1, 120, -1, -1 };
        Node root1 = ct.createTree(data1);
        System.out.println(morrisTraversal(root1));
        int data2[] = { 10, 20, 50, 65, -1, -1, 90, -1, -1, 70, -1, -1, 30, 60, -1, -1, 110, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        System.out.println(morrisTraversal(root2));
        int data3[] = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
        ct.idx = 0;
        Node root3 = ct.createTree(data3);
        System.out.println(morrisTraversal(root3));
        int data4[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, -1, -1 };
        ct.idx = 0;
        Node root4 = ct.createTree(data4);
        System.out.println(morrisTraversal(root4));
        int data5[] = { 6, -1, 8, -1, 29, 20, 5, 9, -1, 10, -1, 13, -1, -1, 17, -1, 19, -1, -1, 23, -1, 25, -1, -1, 32,
                30, -1, -1, 35, 33, -1, -1, 39, -1, -1 };
        ct.idx = 0;
        Node root5 = ct.createTree(data5);
        System.out.println(morrisTraversal(root5));
    }
}
