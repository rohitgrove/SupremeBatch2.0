import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PreorderInorderAndPostOrderCreateTree {
    public static int searchInorder(int inorder[], int size, int target) {
        for (int i = 0; i < size; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void createMapping(int inorder[], int size, HashMap<Integer, Integer> valueToIndexMap) {
        for (int i = 0; i < size; i++) {
            int element = inorder[i];
            int index = i;
            valueToIndexMap.put(element, index);
        }
    }

    public static Node constructTreeFromPreAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int preOrder[], int inOrder[], int[] preIndex, int inOrderStart, int inOrderEnd, int size) {
        // base case
        if (preIndex[0] >= size || inOrderStart > inOrderEnd) {
            return null;
        }

        // solving one case
        int element = preOrder[preIndex[0]];
        preIndex[0]++;
        Node root = new Node(element);
        // search element in inorder
        int position = valueToIndexMap.get(element);
        // recursion handles the rest
        root.left = constructTreeFromPreAndInorderTraversal(valueToIndexMap, preOrder, inOrder, preIndex, inOrderStart,
                position - 1, size);
        root.right = constructTreeFromPreAndInorderTraversal(valueToIndexMap, preOrder, inOrder, preIndex, position + 1,
                inOrderEnd, size);

        return root;
    }

    public static Node constructTreeFromPostAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int postOrder[], int inOrder[], int[] postIndex, int inOrderStart, int inOrderEnd, int size) {
        if (postIndex[0] < 0 || inOrderStart > inOrderEnd) {
            return null;
        }

        // solving one case
        int element = postOrder[postIndex[0]];
        postIndex[0]--;
        Node root = new Node(element);
        // search element in inorder
        int position = valueToIndexMap.get(element);
        // recursion handles the rest
        // right call first
        root.right = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex,
                position + 1, inOrderEnd, size);
        root.left = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex,
                inOrderStart, position - 1, size);

        return root;
    }

    // Method to perform level order traversal
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage for preOrder and inOrder
        // int inorder[] = { 10, 8, 6, 2, 4, 12 };
        // int preOrder[] = { 2, 8, 10, 6, 4, 12 };
        // int size = 6;
        // int[] preOrderIndex = {0};
        // int inorderStart = 0;
        // int inorderEnd = 5;
        // HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        // createMapping(inorder, size, valueToIndexMap);
        // Node root = constructTreeFromPreAndInorderTraversal(valueToIndexMap,
        // preOrder, inorder, preOrderIndex, inorderStart, inorderEnd, size);

        int inorder[] = { 8, 14, 6, 2, 10, 4 };
        int postOrder[] = { 8, 6, 14, 4, 10, 2 };
        int size = 6;
        int[] postIndex = { size - 1 };
        int inorderStart = 0;
        int inorderEnd = size - 1;
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        createMapping(inorder, size, valueToIndexMap);
        Node root = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inorder, postIndex,
                inorderStart, inorderEnd, size);

        System.out.println("Printing the entire tree: ");
        levelOrderTraversal(root);
    }
}
