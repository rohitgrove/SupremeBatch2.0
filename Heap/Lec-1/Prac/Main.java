public class Main {
    public static void main(String[] args) {
        Heap h = new Heap(20);
        // insertion
        h.insert(10);
        h.insert(20);
        h.insert(5);
        h.insert(11);
        h.insert(6);

        h.printHeap();

        System.out.println("answer: " + h.delete());

        h.printHeap();
    }
}
