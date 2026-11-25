class Solution {
    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        int count = 0;

        // Check karo ki k nodes available hain ya nahi
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Agar humne k nodes dhundh liye, toh reverse karo
        // Agar k se kam hain (last group), toh count == k nahi hoga, par fir bhi question ke hisaab se reverse karna hai
        curr = head;
        Node prev = null;
        Node next = null;
        int i = 0;

        // Group ke andar ke nodes ko reverse karo
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Agar aage aur nodes bache hain, toh recursively unhe reverse karo aur jod do
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // prev ab naye group ka head hai
        return prev;
    }
}