public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.print();

        q.add(10);
        q.print();
        q.add(20);
        q.print();
        q.add(30);
        q.print();
        q.add(40);
        q.print();
        q.add(50);
        q.print();

        System.out.println("Size of Queue: " + q.getSize());

        q.poll();
        q.print();

        System.out.println("Size of Queue: " + q.getSize());
        System.out.println("Queue is empty or not: " + q.isEmpty());

        q.poll();
        q.poll();
        q.poll();
        q.print();

        System.out.println(q.peek());
        q.poll();
        q.print();
        System.out.println(q.getSize());
    }
}
