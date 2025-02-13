public class Main {
    public static void main(String[] args) {
        KQueue q = new KQueue(3, 6);
        System.out.println(q.push(1, 1));
        System.out.println(q.push(10, 1));
        System.out.println(q.push(10, 1));
        System.out.println(q.push(14, 2));
        System.out.println(q.push(15, 3));
        System.out.println(q.pop(1));
        System.out.println(q.pop(2));
    }
}