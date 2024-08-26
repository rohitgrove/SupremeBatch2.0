import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class PreInAndPostOrderConstruct {
    public static void createMapping(int[] inorder, int size, HashMap<Integer, Integer> valueToIndexMap) {
        for (int i = 0; i < size; i++) {
            int element = inorder[i];
            valueToIndexMap.put(element, i);
        }
    }

    public static Node constructTreeFromPreAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int[] preOrder, int[] inorder, int[] preOrderIndex, int inorderStart, int inorderEnd, int size) {
        if (preOrderIndex[0] >= size || inorderStart > inorderEnd) {
            return null;
        }

        int element = preOrder[preOrderIndex[0]];
        preOrderIndex[0]++;

        int index = valueToIndexMap.get(element);

        Node root = new Node(element);

        root.left = constructTreeFromPreAndInorderTraversal(valueToIndexMap, preOrder, inorder, preOrderIndex,
                inorderStart, index - 1, size);
        root.right = constructTreeFromPreAndInorderTraversal(valueToIndexMap, preOrder, inorder, preOrderIndex,
                index + 1, inorderEnd, size);
        return root;
    }

    public static Node constructTreeFromPostAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int[] preOrder, int[] inorder, int[] postOrderIndex, int inorderStart, int inorderEnd, int size) {
        if (postOrderIndex[0] < 0 || inorderStart > inorderEnd) {
            return null;
        }

        int element = preOrder[postOrderIndex[0]];
        postOrderIndex[0]--;

        int index = valueToIndexMap.get(element);

        Node root = new Node(element);

        root.right = constructTreeFromPostAndInorderTraversal(valueToIndexMap, preOrder, inorder, postOrderIndex,
                index + 1, inorderEnd, size);

        root.left = constructTreeFromPostAndInorderTraversal(valueToIndexMap, preOrder, inorder, postOrderIndex,
                inorderStart, index - 1, size);
        return root;
    }

    public static void levelOrder(Node root) {
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

        System.out.println();
    }

    public static void main(String[] args) {
        // int inorder[] = { 10, 8, 6, 2, 4, 12 };
        // int preOrder[] = { 2, 8, 10, 6, 4, 12 };
        // int size = inorder.length;
        // int[] preOrderIndex = { 0 };
        // int inorderStart = 0;
        // int inorderEnd = size - 1;
        // HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        // createMapping(inorder, size, valueToIndexMap);
        // Node root = constructTreeFromPreAndInorderTraversal(valueToIndexMap,
        // preOrder, inorder, preOrderIndex,
        // inorderStart, inorderEnd, size);

        // levelOrder(root);
        int inorder[] = { 8, 14, 6, 2, 10, 4 };
        int postOrder[] = { 8, 6, 14, 4, 10, 2 };
        int size = inorder.length;
        int[] postIndex = { size - 1 };
        int inorderStart = 0;
        int inorderEnd = size - 1;
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        createMapping(inorder, size, valueToIndexMap);
        Node root = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inorder, postIndex,
                inorderStart, inorderEnd, size);

        System.out.println("Printing the entire tree: ");
        levelOrder(root);
    }
}
