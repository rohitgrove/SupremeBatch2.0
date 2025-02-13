public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}
