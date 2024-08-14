public class SumOfTheLongestBloodlineOfATree {
    static class Pair {
        int height, sum;

        Pair(int height, int sum) {
            this.height = height;
            this.sum = sum;
        }
    }

    public static Pair height(Node root) {
        if (root == null)
            return new Pair(0, 0);

        Pair lh = height(root.left);
        Pair rh = height(root.right);

        int sum = root.data;
        if (lh.height > rh.height) {
            sum += lh.sum;
        } else if (lh.height < rh.height) {
            sum += rh.sum;
        } else {
            sum += (lh.sum > rh.sum) ? lh.sum : rh.sum;
        }

        return new Pair(Math.max(lh.height, rh.height) + 1, sum);
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        Pair h = height(root);
        return h.sum;
    }

    public static void main(String[] args) {
        int data1[] = { 4, 2, 7, -1, -1, 1, 6, -1, -1, -1, 5, 2, -1, -1, 3, -1, -1 };
        ConstructTree ct1 = new ConstructTree();
        Node root1 = ct1.createTree(data1);
        ct1.bfs(root1);
        System.out.println(sumOfLongRootToLeafPath(root1));
        int data2[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        ConstructTree ct2 = new ConstructTree();
        Node root2 = ct2.createTree(data2);
        ct2.bfs(root2);
        System.out.println(sumOfLongRootToLeafPath(root2));
    }
}
