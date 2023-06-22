package exercise.LinkedList;

import model.Node;

import java.util.HashMap;
import java.util.Map;

public class LC138CopyWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node copied = new Node(curr.val);
            copyMap.put(curr, copied);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node temp = copyMap.get(curr);
            temp.next = copyMap.get(curr.next);
            temp.random = copyMap.get(curr.random);
            curr = curr.next;
        }
        return copyMap.get(head);
    }
}
