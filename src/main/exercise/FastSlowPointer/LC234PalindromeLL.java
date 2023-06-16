package exercise.FastSlowPointer;

import model.ListNode;

public class LC234PalindromeLL {

    public static ListNode reverseLL(ListNode head) {
        ListNode rev = null;
        ListNode temp = head;
        ListNode temp2;

        while (temp != null) {
            temp2 = temp.next;
            temp.next = rev;
            rev = temp;
            temp = temp2;
        }
        return rev;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode revHead = null;
        ListNode slow = head;
        ListNode temp;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // move fast pointer first
            fast = fast.next.next;
            // reverse the list
            temp = slow.next;
            slow.next = revHead;
            revHead = slow;
            slow = temp;
        }
        // when odd number of linked list nodes
        if (fast != null) {
            slow = slow.next;
            while (slow != null) {
                if (slow.val != revHead.val) return false;
                slow = slow.next;
                revHead = revHead.next;
            }
        }
        // when even number of linked list nodes
        if (fast == null) {
            while (slow != null) {
                if (slow.val != revHead.val) return false;
                slow = slow.next;
                revHead = revHead.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = n1;
        System.out.println(ListNode.displayLinkedList(head));
        System.out.println(LC234PalindromeLL.isPalindrome(head));
    }
}
