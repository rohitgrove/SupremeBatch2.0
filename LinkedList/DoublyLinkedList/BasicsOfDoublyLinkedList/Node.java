public class Node {
    public int data;
    Node prev;
    Node next;

    public Node() {
        this.prev = null;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
