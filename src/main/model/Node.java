package model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node createLLFromArray(int[] arr) {
        Node head;
        if (arr.length == 0) {
            return null;
        } else {
            head = new Node(arr[0]);
            Node curr = head;
            for (int i = 1; i < arr.length; i++) {
                curr.next = new Node(arr[i]);
                curr = curr.next;
            }
        }
        return head;
    }

    public static String displayLinkedList(Node head) {
        Node temp = head;
        List<String> vals = new ArrayList<>();
        while (temp != null) {
            vals.add(Integer.toString(temp.val));
            temp = temp.next;
        }
        return "[" + String.join("->", vals) + "]";
    }
}
