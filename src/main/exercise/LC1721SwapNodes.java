package exercise;

import model.ListNode;

public class LC1721SwapNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) return head;
        int n = 0;
        int c;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (n <= 2) {
            ListNode rev = null;
            ListNode prev = head;
            ListNode curr = head;
            curr = curr.next;
            prev.next = rev;
            curr.next = prev;
            head = curr;
        } else {
            if (k > n) return null;
            c = n - k + 1;
            if (c == k) return head;
            if (k > c) {
                int temp_num = k;
                k = c;
                c = temp_num;
            }
            int temp_k = k;
            int temp_c = c;
            // k is index 1, complement is index 2
            ListNode ptr1 = head;
            ListNode ptr2 = head;
            int counter1 = 1;
            while (counter1 < temp_k - 1) {
                ptr1 = ptr1.next;
                counter1++;
            }
            int counter2 = 1;
            while (counter2 < temp_c - 1) {
                ptr2 = ptr2.next;
                counter2++;
            }
            if (k == 1) {
                ListNode dummyHead = new ListNode(1);
                dummyHead.next = ptr2.next;
                ptr2.next.next = ptr1.next;
                ptr2.next = ptr1;
                ptr1.next = null;
                return dummyHead.next;
            }
            if (Math.abs(temp_c - temp_k) > 2) {
                ListNode ptr3 = ptr2.next.next;
                ListNode ptr4 = ptr1.next.next;
                ListNode ptr5 = ptr1.next;

                ptr1.next.next = ptr3;
                ptr2.next.next = ptr4;
                ptr1.next = ptr2.next;
                ptr2.next = ptr5;
            } else if (Math.abs(temp_c - temp_k) > 1) { // == 2
                ptr1.next.next = ptr2.next.next;
                ptr2.next.next = ptr2;
                ptr2 = ptr2.next;
                ptr2.next.next = ptr1.next;
                ptr1.next = ptr2;
            } else { // == 1
                ptr1.next = ptr2.next;
                ptr2.next = ptr2.next.next;
                ptr1.next.next = ptr2;
            }
        }
        return head;
    }


    public static void main(String[] args) {
//        ListNode n1 = new ListNode(80);
//        ListNode n2 = new ListNode(46);
//        ListNode n3 = new ListNode(66);
//        ListNode n4 = new ListNode(35);
//        ListNode n5 = new ListNode(64);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        ListNode n1 = new ListNode(7);
//        ListNode n2 = new ListNode(9);
//        ListNode n3 = new ListNode(6);
//        ListNode n4 = new ListNode(6);
//        ListNode n5 = new ListNode(7);
//        ListNode n6 = new ListNode(8);
//        ListNode n7 = new ListNode(3);
//        ListNode n8 = new ListNode(0);
//        ListNode n9 = new ListNode(9);
//        ListNode n10 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n9;
//        n9.next = n10;
        ListNode n1 = new ListNode(91);
        ListNode n2 = new ListNode(56);
        ListNode n3 = new ListNode(48);
        ListNode n4 = new ListNode(77);
        ListNode n5 = new ListNode(91);
        ListNode n6 = new ListNode(96);
        ListNode n7 = new ListNode(55);
        ListNode n8 = new ListNode(53);
        ListNode n9 = new ListNode(68);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        System.out.println(ListNode.displayLinkedList(n1));
        System.out.println(ListNode.displayLinkedList(LC1721SwapNodes.swapNodes(n1, 7)));
    }

}
