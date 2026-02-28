public class Main {
    public static void main(String[] args) {
        KQueue q = new KQueue(8, 3);
        System.out.println(q.push(1, 0));
        System.out.println(q.push(2, 0));
        System.out.println(q.push(5, 1));
        System.out.println(q.push(3, 0));
        System.out.println(q.pop(1));
        System.out.println(q.pop(1));
        System.out.println(q.pop(0));
        System.out.println(q.pop(0));
        System.out.println(q.pop(0));
        System.out.println(q.pop(0));
        System.out.println(q.pop(0));
        System.out.println(q.pop(1));
    }
}