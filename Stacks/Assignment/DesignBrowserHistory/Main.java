public class Main {
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("google.com");
        obj.visit("facebook.com");
        obj.visit("youtube.com");
        System.out.println(obj.back(1)); // returns "facebook.com"
        System.out.println(obj.back(1)); // returns "google.com"
        System.out.println(obj.forward(1)); // returns "facebook.com"
        obj.visit("linkedin.com");
        System.out.println(obj.forward(2)); // returns "linkedin.com"
        System.out.println(obj.back(2)); // returns "google.com"
        System.out.println(obj.back(7)); // returns "leetcode.com"
    }    
}
