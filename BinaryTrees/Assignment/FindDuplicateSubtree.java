import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class FindDuplicateSubtree {
    public static List<Node> findDuplicateSubtrees(Node root) {
        List<Node> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        helper(res, root, hm);
        return res;
    }

    public static String helper(List<Node> res, Node root, HashMap<String, Integer> hm) {
        if (root == null)
            return "";
        String left = helper(res, root.left, hm);
        String right = helper(res, root.right, hm);
        int currroot = root.data;
        String stringformed = currroot + "$" + left + "$" + right;
        if (hm.getOrDefault(stringformed, 0) == 1) {
            res.add(root);
        }
        hm.put(stringformed, hm.getOrDefault(stringformed, 0) + 1);
        return stringformed;
    }

    public static void main(String[] args) {
        int data[] = { 1, 2, 4, -1, -1, -1, 3, 2, 4, -1, -1, -1, 4, -1, -1 };
        ConstructTree ct = new ConstructTree();
        Node root = ct.createTree(data);
        List<Node> list = new ArrayList<>(findDuplicateSubtrees(root));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).data+" ");
        }
    }
}
