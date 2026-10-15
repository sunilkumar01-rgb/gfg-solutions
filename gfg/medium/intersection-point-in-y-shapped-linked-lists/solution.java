class Solution {
    Node intersectPoint(Node head1, Node head2) {
        Node a = head1, b = head2;

        while (a != b) {
            a = (a == null) ? head2 : a.next;
            b = (b == null) ? head1 : b.next;
        }

        return a;
    }
}