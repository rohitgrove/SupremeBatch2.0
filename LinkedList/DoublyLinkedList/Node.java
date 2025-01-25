public class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node() {
        prev = null;
        next = null;
    }

    public Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}