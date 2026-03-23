import java.util.Stack;

public class BrothersFromDifferentRootsMethod2 {
    public static int countPairs(Node root1, Node root2, int x) {
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
                // reverse inorder
                s2.push(b);
                b = b.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node aTop = s1.peek();
            Node bTop = s2.peek();

            int sum = aTop.data + bTop.data;

            if (sum == x) {
                ans++;
                s1.pop();
                s2.pop();
                a = aTop.right;
                b = bTop.left;
            } else if (sum < x) {
                s1.pop();
                a = aTop.right;
            } else {
                s2.pop();
                b = bTop.left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int data1[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root1 = ConstructTree.createBST(data1);
        int data2[] = { 10, 6, 15, 3, 8, 11, 18 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(countPairs(root1, root2, 16));
    }
}
