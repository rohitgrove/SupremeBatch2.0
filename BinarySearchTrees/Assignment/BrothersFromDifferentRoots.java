import java.util.ArrayList;
import java.util.Stack;

public class BrothersFromDifferentRoots {
    public static boolean searchInBST(Node root, int tar) {
        if (root == null) {
            return false;
        }

        if (root.data == tar) {
            return true;
        } else if (root.data > tar) {
            return searchInBST(root.left, tar);
        } else {
            return searchInBST(root.right, tar);
        }
    }

    public static int method1(Node root1, Node root2, int x) {
        if (root1 == null) {
            return 0;
        }

        int ans1 = method1(root1.left, root2, x);
        int ans2 = method1(root1.right, root2, x);

        int complement = x - root1.data;
        boolean foundInRoot2 = searchInBST(root2, complement);

        int pairs = foundInRoot2 ? 1 : 0;

        return ans1 + ans2 + pairs;
    }

    public static void inOrder(Node root, ArrayList<Integer> bst1) {
        if (root == null) {
            return;
        }

        inOrder(root.left, bst1);
        bst1.add(root.data);
        inOrder(root.right, bst1);
    }

    public static void inOrderRev(Node root, ArrayList<Integer> bst2) {
        if (root == null) {
            return;
        }

        inOrderRev(root.right, bst2);
        bst2.add(root.data);
        inOrderRev(root.left, bst2);
    }

    public static int method2(Node root1, Node root2, int x) {
        ArrayList<Integer> bst1 = new ArrayList<>();
        ArrayList<Integer> bst2 = new ArrayList<>();

        inOrder(root1, bst1);
        inOrderRev(root2, bst2);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < bst1.size() && j < bst2.size()) {
            int sum = bst1.get(i) + bst2.get(j);

            if (sum == x) {
                count++;
                i++;
                j++;
            } else if (sum > x) {
                j++;
            } else {
                i++;
            }
        }

        return count;
    }

    public static int method3(Node root1, Node root2, int x) {
        int ans = 0;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node a = root1;
        Node b = root2;

        while (true) {
            while (a != null) {
                // inorder
                s1.push(a);
                a = a.left;
            }

            while (b != null) {
                // rev inorder
                s2.push(b);
                b = b.right;
            }


            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node atop = s1.peek();
            Node btop = s2.peek();


            int sum = atop.data + btop.data;
            if (sum == x) {
                ++ans;
                s1.pop();                
                s2.pop();                
                a = atop.right;
                b = btop.left;
            } else if (sum < x) {
                s1.pop();
                a = atop.right;
            } else {
                s2.pop();
                b = btop.left;
            }
        }

        return ans;
    }

    public static int countPairs(Node root1, Node root2, int x) {
        return method3(root1, root2, x);
    }

    public static void main(String[] args) {
        int BST1[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root1 = ConstructTree.createTree(BST1);
        int BST2[] = { 10, 6, 15, 3, 8, 11, 18 };
        Node root2 = ConstructTree.createTree(BST2);
        int x = 16;
        System.out.println(countPairs(root1, root2, x));
    }
}
