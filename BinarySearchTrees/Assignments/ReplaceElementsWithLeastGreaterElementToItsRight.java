
public class ReplaceElementsWithLeastGreaterElementToItsRight {
    public static Node insert(Node root, int val, int[] succ) {
        if (root == null) {
            return new Node(val);
        }

        if (val >= root.data) {
            root.right = insert(root.right, val, succ);
        } else {
            succ[0] = root.data;
            root.left = insert(root.left, val, succ);
        }

        return root;
    }

    public static int[] leastGreaterElement(int[] arr) {
        int ans[] = new int[arr.length];
        Node root = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            int[] succ = { -1 };
            root = insert(root, arr[i], succ);
            ans[i] = succ[0];
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
        printArr(leastGreaterElement(arr1));
        int arr2[] = { 17, 18, 5, 4, 6, 1 };
        printArr(leastGreaterElement(arr2));
    }
}
