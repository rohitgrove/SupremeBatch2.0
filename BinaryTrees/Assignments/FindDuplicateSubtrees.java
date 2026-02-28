import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    static List<Node> ans = new ArrayList<>();
    static HashMap<String, Integer> subTreeMap = new HashMap<>();

    public static List<Node> findDuplicateSubtrees(Node root) {
        preOrder(root);
        return ans;
    }

    public static String preOrder(Node root) {
        if (root == null) {
            return "N";
        }

        String curr = Integer.toString(root.data);
        String l = preOrder(root.left);
        String r = preOrder(root.right);

        String s = curr + "," + l + "," + r;
        if (subTreeMap.containsKey(s)) {
            if (subTreeMap.get(s) == 1) {
                ans.add(root);
            }
            subTreeMap.put(s, subTreeMap.get(s) + 1);
        } else {
            subTreeMap.put(s, 1);
        }

        return s;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int data1[] = { 1, 2, 4, -1, -1, -1, 2, 4, -1, -1, -1, 4, -1, -1 };
        Node root1 = ct.createTree(data1);
        List<Node> res = new ArrayList<>(findDuplicateSubtrees(root1));
        for (Node node : res) {
            ct.levelOrder(node);
        }

        int data2[] = { 2, 2, 3, -1, -1, -1, 2, 3, -1, -1, -1 };
        ct.idx = 0;
        Node root2 = ct.createTree(data2);
        res = new ArrayList<>(findDuplicateSubtrees(root2));
        for (Node node : res) {
            ct.levelOrder(node);
        }
    }
}
