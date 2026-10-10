class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head.val >= 5) {
            head = new ListNode(0, head);
        }
        
        ListNode curr = head;
        while (curr != null) {
            curr.val = (curr.val * 2) % 10;
            if (curr.next != null && curr.next.val >= 5) {
                curr.val++;
            }
            curr = curr.next;
        }
        
        return head;
    }
}