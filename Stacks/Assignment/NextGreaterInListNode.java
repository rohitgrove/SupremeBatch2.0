import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this.next = null;
    }

    public ListNode(int val) {
        this.next = null;
        this.val = val;
    }
}

public class NextGreaterInListNode {
    public static Object[] nextLargerNodes1(ListNode head) {
        ArrayList<Integer> ll = new ArrayList<>();
        while (head != null) {
            ll.add(head.val);
            head = head.next;
        }

        Stack<Integer> st = new Stack<>();
        // int ans[] = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            while (!st.empty() && ll.get(i) > ll.get(st.peek())) {
                // means, ith elemnt is the nextgreater of the elemnt index present in stack
                int kids = st.pop();
                ll.set(kids, ll.get(i));
            }
            st.push(i);
        }


        while (!st.empty()) {
            ll.set(st.pop(), 0);   
        }
        ll.set(ll.size() - 1, 0);
        return ll.toArray();
    }

    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> ll = new ArrayList<>();
        while (head != null) {
            ll.add(head.val);
            head = head.next;
        }

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            while (!st.empty() && ll.get(i) > ll.get(st.peek())) {
                // means, ith elemnt is the nextgreater of the elemnt index present in stack
                int kids = st.pop();
                ans[kids] = ll.get(i);
            }
            st.push(i);
        }

        
        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode head = first;

        printArr(nextLargerNodes(head));
    }
}
