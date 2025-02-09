public class Main {
    public static void main(String[] args) {
        CircluarQueue q = new CircluarQueue(5);
        q.print();

        q.offer(10);
        q.print();

        q.offer(20);
        q.print();

        q.offer(30);
        q.print();

        q.offer(40);
        q.print();

        q.offer(50);
        q.print();

        // q.offer(60);
        // q.print();

        q.pop();
        q.pop();
        q.pop();
        q.print();
        q.offer(100);
        q.print();
        q.offer(110);
        q.print();
        q.offer(120);
        q.print();
        q.offer(130);
        q.print();
    }
}
