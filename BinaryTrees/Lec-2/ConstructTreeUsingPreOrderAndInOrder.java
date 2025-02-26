import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeUsingPreOrderAndInOrder {
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node front = q.poll();
            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.offer(front.left);
                }

                if (front.right != null) {
                    q.offer(front.right);
                }
            }
        }
    }

    public static int searchInorder(int[] inOrder, int size, int element) {
        for (int i = 0; i < size; i++) {
            if (inOrder[i] == element) {
                return i;
            }
        }

        return -1;
    }

    public static void createMapping(int inOrder[], int size, HashMap<Integer, Integer> valueToIndexMap) {
        for (int i = 0; i < size; i++) {
            int element = inOrder[i];
            int index = i;
            valueToIndexMap.put(element, index);
        }
    }

    public static Node constructNodeFromPreAndInorederTraversal(int preOrder[], int inOrder[], int preIndex[],
            int inOrderStart, int inOrderEnd, int size, HashMap<Integer, Integer> valueToIndex) {

        if (preIndex[0] >= size || inOrderStart > inOrderEnd) {
            return null;
        }

        // 1 case main solve karta hu
        int element = preOrder[preIndex[0]];
        preIndex[0]++;
        Node root = new Node(element);
        // element search karna padega inorder me
        int postion = valueToIndex.get(element);

        // baaki recursion sambhal lega
        root.left = constructNodeFromPreAndInorederTraversal(preOrder, inOrder, preIndex, inOrderStart, postion - 1,
                size, valueToIndex);
        root.right = constructNodeFromPreAndInorederTraversal(preOrder, inOrder, preIndex, postion + 1, inOrderEnd,
                size, valueToIndex);
        return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        int preOrderIndex[] = { 0 };
        int inOrderStart = 0;
        int inorderEnd = preorder.length - 1;
        int size = preorder.length;
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        createMapping(inorder, size, valueToIndex);
        return constructNodeFromPreAndInorederTraversal(preorder, inorder, preOrderIndex, inOrderStart, inorderEnd,
                size, valueToIndex);
    }

    public static void main(String[] args) {
        int inorder[] = { 10, 8, 6, 2, 4, 12 };
        int preOrder[] = { 2, 8, 10, 6, 4, 12 };
        Node root = buildTree(preOrder, inorder);
        levelOrder(root);
    }
}
