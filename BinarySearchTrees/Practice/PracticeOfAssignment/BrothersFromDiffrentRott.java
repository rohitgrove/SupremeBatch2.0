import java.util.Stack;

public class BrothersFromDiffrentRott {
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
    public static void main(String[] args) {
        int BST1[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root1 = ConstructTree.createTree(BST1);
        int BST2[] = { 10, 6, 15, 3, 8, 11, 18 };
        Node root2 = ConstructTree.createTree(BST2);
        int x = 16;
        System.out.println(countPairs(root1, root2, x));
    } 
}
