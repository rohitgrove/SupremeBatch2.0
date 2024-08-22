public class FindMedianOfBST {
    public static int findNodeCount(Node root) {
        int count = 0;
        Node curr = root;
        while (curr != null) {
            // left node is null, then visit it and go right
            if (curr.left == null) {
                count++;
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
                    count++;
                    curr = curr.right;
                }
            }
        }
        return count;
    }

    public static float findActualMedain(Node root, int n) {
        int i = 0;
        Node curr = root;
        int odd1 = (n + 1) / 2, odd1Val = - 1;
        int even1 = n / 2, even1Val = -1;
        int even2 = n / 2 + 1, even2Val = -1;

        while (curr != null) {
            // left node is null, then visit it and go right
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
        float median = 0;
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
        return findActualMedain(root, n);
    }

    public static void main(String[] args) {
        int data1[] = {6,3,8,1,4,7,9};
        Node root1 = ConstructTree.createTree(data1);
        System.out.println(findMedian(root1)); 

        int data2[] = {6,3,8,1,4,7,9};
        Node root2 = ConstructTree.createTree(data2);
        System.out.println(findMedian(root2));        
    }
}
