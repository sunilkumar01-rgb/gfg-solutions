class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        curr.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }
}