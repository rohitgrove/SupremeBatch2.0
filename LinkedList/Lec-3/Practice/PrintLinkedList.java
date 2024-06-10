public class PrintLinkedList {
    public void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
