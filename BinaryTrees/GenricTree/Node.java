public class Node {
    int data;
    int childrenCount;
    Node[] children;

    // Constructor to initialize node with data
    public Node(int value) {
        this.data = value;
        this.childrenCount = 0;
        this.children = null;
    }
}