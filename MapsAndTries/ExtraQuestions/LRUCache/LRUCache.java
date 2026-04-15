import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> mpp;
    private int cap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        mpp = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void deletionNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!mpp.containsKey(key)) {
            return -1;
        }
        Node node = mpp.get(key);
        deletionNode(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (mpp.containsKey(key)) {
            Node node = mpp.get(key);
            node.val = value;
            deletionNode(node);
            insertAfterHead(node);
        } else {
            if (mpp.size() == cap) {
                Node node = tail.prev;
                mpp.remove(node.key, node);
                deletionNode(node);
            }

            Node node = new Node(key, value);
            mpp.put(key, node);
            insertAfterHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */