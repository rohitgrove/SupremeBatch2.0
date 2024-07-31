public class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.print();

        cq.add(10);
        cq.print();
        cq.add(20);
        cq.print();
        cq.add(30);
        cq.print();
        cq.add(40);
        cq.print();
        cq.add(50);
        cq.print();
        // cq.add(60);
        // cq.print();


        cq.poll();
        cq.poll();
        cq.poll();
        cq.print();
        cq.add(100);
        cq.print();
        cq.add(110);
        cq.print();
        cq.add(120);
        cq.print();
        cq.add(130);
        cq.print();
    }
}
