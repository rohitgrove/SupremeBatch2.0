public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
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

        System.out.println("Size of Queue: " + q.size());

        q.pop();
        q.print();
        System.out.println("Size of Queue: " + q.size());

        System.out.println("Queue is empty or not: " + q.isEmpty());
        // q.offer(100);
        // q.print();

        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.getFront());
        q.pop();
        q.print();
        System.out.println(q.size());
    }
}
