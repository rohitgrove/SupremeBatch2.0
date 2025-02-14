public class Main {
    public static void main(String[] args) {
        Deque dq = new Deque();
        dq.print();

        dq.offerFirst(5);
        dq.print();

        dq.offerLast(6);
        dq.print();

        dq.pollFirst();
        dq.print();
        
        dq.offerFirst(5);
        dq.print();

        dq.offerLast(7);
        dq.print();
        dq.offerLast(8);
        dq.print();
        dq.offerLast(9);
        dq.print();

        dq.pollLast();
        dq.pollLast();
        dq.pollLast();
        dq.pollLast();
        dq.pollLast();
        dq.print();
        dq.pollFirst();
    }
}
