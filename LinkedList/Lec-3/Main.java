public class Main {
    public static void main(String[] args) {
        // PrintLinkedList pll = new PrintLinkedList();
        // ListNode first = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(3);
        // ListNode fourth = new ListNode(4);
        // ListNode fifth = new ListNode(5);
        // ListNode sixth = new ListNode(6);

        // ListNode head = first;
        // first.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next = fifth;
        // fifth.next = sixth;

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

        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);
        ListNode sixth = new ListNode(60);
    
        ListNode head = first;
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
