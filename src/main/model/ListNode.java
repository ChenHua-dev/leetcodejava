package model;

import java.util.*;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createLLFromArray(int[] arrayList) {

        return null;
    }

    public static String displayLinkedList(ListNode head) {
        ListNode temp = head;
        List<String> vals = new ArrayList<>();
        while (temp != null) {
            vals.add(Integer.toString(temp.val));
            temp = temp.next;
        }
        return "[" + String.join("->", vals) + "]";
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode head = n1;
        System.out.println(ListNode.displayLinkedList(head));
    }
}
