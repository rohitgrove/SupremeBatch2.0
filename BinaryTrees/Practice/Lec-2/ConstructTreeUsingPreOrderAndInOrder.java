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
        System.out.println();
    }

    public static void createMapping(int[] inorder, int size, HashMap<Integer, Integer> visitToIndex) {
        for (int i = 0; i < size; i++) {
            int element = inorder[i];
            int index = i;
            visitToIndex.put(element, index);
        }
    }

    public static Node constructTreeFromPreAndPostOrder(int[] preOrder, int[] inorder, int[] preIndex,
            int inorderStartIndex, int inorderEndIndex, int size,  HashMap<Integer, Integer> visitToIndex) {
        if (preIndex[0] > size || inorderStartIndex > inorderEndIndex) {
            return null;
        }

        int element = preOrder[preIndex[0]];
        preIndex[0]++;
        Node root = new Node(element);

        int position = visitToIndex.get(element);

        root.left = constructTreeFromPreAndPostOrder(preOrder, inorder, preIndex, inorderStartIndex, position - 1, size, visitToIndex);
        root.right = constructTreeFromPreAndPostOrder(preOrder, inorder, preIndex, position + 1, inorderEndIndex, size, visitToIndex);

        return root;
    }

    public static Node buildTree(int preOrder[], int inorder[]) {
        int size = preOrder.length;
        int preIndex[] = { 0 };
        int inorderStartIndex = 0;
        int inorderEndIndex = size - 1;
        HashMap<Integer, Integer> visitToIndex = new HashMap<>();
        createMapping(inorder, size, visitToIndex);

        return constructTreeFromPreAndPostOrder(preOrder, inorder, preIndex, inorderStartIndex, inorderEndIndex, size, visitToIndex);
    }

    public static void main(String[] args) {
        int inorder[] = { 10, 8, 6, 2, 4, 12 };
        int preOrder[] = { 2, 8, 10, 6, 4, 12 };
        Node root = buildTree(preOrder, inorder);
        levelOrder(root);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.left.left.data);
        System.out.println(root.right.data);
        System.out.println(root.right.right.data);
    }
}
