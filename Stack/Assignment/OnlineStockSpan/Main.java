public class Main {
    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(100));
        System.out.println(sp.next(80));
        System.out.println(sp.next(60));
        System.out.println(sp.next(70));
        System.out.println(sp.next(60));
        System.out.println(sp.next(75));
        System.out.println(sp.next(85));
    }
}
