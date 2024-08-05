public class Main {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));    // Output: 1
        System.out.println(rc.ping(100));  // Output: 2
        System.out.println(rc.ping(3001)); // Output: 3
        System.out.println(rc.ping(3002)); // Output: 3
    }
}