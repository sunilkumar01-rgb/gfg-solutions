import java.util.*;

class Solution {
    public Node makeUnion(Node head1, Node head2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // Pehli list ke elements add karo
        Node curr = head1;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Dusri list ke elements add karo (jo pehle se nahi hain)
        curr = head2;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Nayi Linked List banao
        if (set.isEmpty()) return null;

        Node dummy = new Node(0);
        Node temp = dummy;

        for (int val : set) {
            temp.next = new Node(val);
            temp = temp.next;
        }

        return dummy.next;
    }
}