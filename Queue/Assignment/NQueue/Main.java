public class Main {
    public static void main(String[] args) {
        NQueue kq = new NQueue(8, 3);
        
        System.out.println(kq.push(1, 0));
        System.out.println(kq.push(2, 0));
        System.out.println(kq.push(5, 1));
        System.out.println(kq.push(3, 0));
        System.out.println(kq.pop(1));
        System.out.println(kq.pop(1));
        System.out.println(kq.pop(0));
        System.out.println(kq.pop(0));
        System.out.println(kq.pop(0));
        System.out.println(kq.pop(0));
    }   
}
