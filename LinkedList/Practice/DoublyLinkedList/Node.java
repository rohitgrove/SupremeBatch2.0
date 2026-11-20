public class Node {
    public int data;
    public Node next;
    public Node prev;

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