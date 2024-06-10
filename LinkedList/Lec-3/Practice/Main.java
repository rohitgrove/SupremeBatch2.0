public class Main {
    public static void main(String[] args) {
        PrintLinkedList pll = new PrintLinkedList();
        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(3);
        // ListNode fourth = new ListNode(4);
        // ListNode fifth = new ListNode(5);
        // ListNode sixth = new ListNode(6);

        // ReverseLL rll = new ReverseLL();
        // ListNode head = first;
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // fifth.next = sixth;
        // pll.printLL(rll.reverseList(head));
        // pll.printLL(head);
        // MiddleOFLL mll = new MiddleOFLL();
        // System.out.println(mll.middleOfLL(head).data);

        // Example of palindorme 
        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(2);
        // ListNode fourth = new ListNode(1);

        // ListNode head = first;
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // pll.printLL(head);
        // PalindromeLL palindrome = new PalindromeLL();
        // System.out.println(palindrome.isPalindrome(head));

        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(3);
        // ListNode fourth = new ListNode(2);
        // ListNode fifth = new ListNode(1);

        // ListNode head = first;
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // pll.printLL(head);
        // PalindromeLL palindrome = new PalindromeLL();
        // System.out.println(palindrome.isPalindrome(head));

        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);
        Node sixth = new Node(60);
    
        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = second;
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
    }
}
