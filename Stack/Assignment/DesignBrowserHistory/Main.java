public class Main {
    public static void main(String[] args) {
        BrowserHistory bs = new BrowserHistory("leetcode.com");
        bs.visit("google.com");
        bs.visit("facebook.com");
        bs.visit("youtube.com");
        System.out.println(bs.back(1));
        System.out.println(bs.back(1));
        System.out.println(bs.forward(1));
        bs.visit("linkedin.com");
        System.out.println(bs.forward(2));
        System.out.println(bs.back(2));
        System.out.println(bs.back(7));
    }
}
