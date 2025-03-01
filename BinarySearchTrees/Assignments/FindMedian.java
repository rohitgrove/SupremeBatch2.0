public class FindMedian {
    public static int findNodeCount(Node root) {
        Node curr = root;
        int count = 0;
        while (curr != null) {
            // left node is null, then, visit it and go right
            if (curr.left == null) {
                count++;
                curr = curr.right;
            }
            // left node is NOT NULL
            else {
                // find inorder predecesoor
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null) {
                    pred = pred.right;
                }

                // if pred right is Null, then go left after establishing link from pred to
                // curr;
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // left is already visited, Go right after visiting curr node, while removing
                    // the link
                    pred.right = null;
                    count++;
                    curr = curr.right;
                }
            }
        }

        return count;
    }

    public static float findActualMedian(Node root, int n) {
        Node curr = root;
        int i = 0;
        int odd1 = (n + 1) / 2, odd1Val = -1;
        int even1 = n / 2, even1Val = -1;
        int even2 = n / 2 + 1, even2Val = -1;
        while (curr != null) {
            if (curr.left == null) {
                i++;
                if (i == odd1) {
                    odd1Val = curr.data;
                }

                if (i == even1) {
                    even1Val = curr.data;
                }

                if (i == even2) {
                    even2Val = curr.data;
                }

                curr = curr.right;
            } else {
                Node pred = curr.left;
                while (pred.right != curr && pred.right != null) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    i++;
                    if (i == odd1) {
                        odd1Val = curr.data;
                    }
    
                    if (i == even1) {
                        even1Val = curr.data;
                    }
    
                    if (i == even2) {
                        even2Val = curr.data;
                    }
                    curr = curr.right;
                }
            }
        }

        float median;
        if ((n&1) == 0) {
            // even
            median = (float) ((even1Val + even2Val) / 2.0);
        } else {
            // odd
            median = odd1Val;
        }
        return median;
    }

    public static float findMedian(Node root) {
        int n = findNodeCount(root);
        return findActualMedian(root, n);
    }

    public static void main(String[] args) {
        int data1[] = { 6, 3, 8, 1, 4, 7, 9 };
        Node root1 = ConstructTree.createBST(data1);
        System.out.println(findMedian(root1));
        int data2[] = { 6, 3, 8, 1, 4, 7 };
        Node root2 = ConstructTree.createBST(data2);
        System.out.println(findMedian(root2));
    }
}
