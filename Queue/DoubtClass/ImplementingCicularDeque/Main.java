public class Main {
    public static void main(String[] args) {
        MyCircularDeque mcd = new MyCircularDeque(3);
        System.out.println(mcd.insertLast(1));
        System.out.println(mcd.insertLast(2));
        System.out.println(mcd.insertFront(3));
        System.out.println(mcd.insertFront(4));
        System.out.println(mcd.getRear());
        System.out.println(mcd.isFull());
        System.out.println(mcd.deleteLast());
        System.out.println(mcd.insertFront(4));
        System.out.println(mcd.getFront());
    }
}
