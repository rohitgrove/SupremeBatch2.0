public class FNode {
    public int data;
    public FNode next;
    public FNode bottom;

    public FNode() {
        this.next = null;
        this.bottom = null;
    }

    public FNode(int data) {
        this.data = data;
        this.next = null;
        this.bottom = null;
    }
}
