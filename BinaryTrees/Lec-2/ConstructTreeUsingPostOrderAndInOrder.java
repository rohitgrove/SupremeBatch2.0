import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeUsingPostOrderAndInOrder {
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

    public static void createMapping(int[] postorder, int size, HashMap<Integer, Integer> valueToIndex) {
        for (int i = 0; i < size; i++) {
            int element = postorder[i];
            int index = i;
            valueToIndex.put(element, index);
        }
    }

    public static Node constructTreeFromPostAndInorderTraversal(HashMap<Integer, Integer> valueToIndexMap,
            int postOrder[], int inOrder[], int[] postIndex, int inOrderStart, int inOrderEnd, int size) {
        if (postIndex[0] < 0 || inOrderStart > inOrderEnd) {
            return null;
        }

        // 1 case main solve karunga
        int element = postOrder[postIndex[0]];
        postIndex[0]--;
        Node root = new Node(element);
        // search karo inoder main
        int position = valueToIndexMap.get(element);
        // baaki recursion sambhal lega
        // right ki call phele lagegi
        root.right = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex, position + 1, inOrderEnd, size);
        root.left = constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inOrder, postIndex, inOrderStart, position - 1, size);

        return root;
    }

    public static Node buildTree(int[] postOrder, int[] inorder) {
        int size = postOrder.length;
        int[] postIndex = { size - 1 };
        int inorderStart = 0;
        int inorderEnd = size - 1;
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        createMapping(inorder, size, valueToIndexMap);
        return constructTreeFromPostAndInorderTraversal(valueToIndexMap, postOrder, inorder, postIndex,
                inorderStart, inorderEnd, size);
    }

    public static void main(String[] args) {
        int inOrder[] = { 8, 14, 6, 2, 10, 4 };
        int postOrder[] = { 8, 6, 14, 4, 10, 2 };
        Node root = buildTree(postOrder, inOrder);
        levelOrder(root);
    }
}
