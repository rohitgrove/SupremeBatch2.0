public class Main {
    public static void main(String[] args) {
        Deqeue dq = new Deqeue(5);

        dq.addBack(10);
        dq.addBack(20);
        dq.addBack(30);
        dq.print();

        dq.addFront(40);
        dq.print();

        dq.addFront(45);
        dq.print();
    }
}
