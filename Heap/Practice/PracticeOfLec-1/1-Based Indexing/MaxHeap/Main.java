public class Main {
    public static void main(String[] args) {
        Heap h = new Heap(20);
        // insertion
        h.insert(10);
        h.insert(20);
        h.insert(5);
        h.insert(11);
        h.insert(6);

        System.out.println("Printing the content of heap: ");
        h.printHeap();

        int ans = h.deleteFromHeap();
        System.out.println("Answer: " + ans);
        h.printHeap();
    }
}
