public class Node {
    public int data;
    public int childrenCount;
    public Node children[];

    public Node(int val) {
        this.data = val;
        this.childrenCount = 0;
        this.children = null;
    }
}