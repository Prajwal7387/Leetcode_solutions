class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {

            ListNode end = prev;

            // Check if k nodes are available
            for (int i = 0; i < k; i++) {
                end = end.next;

                if (end == null)
                    return dummy.next;
            }

            ListNode curr = prev.next;
            ListNode next = curr.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {

                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;

                next = curr.next;
            }

            prev = curr;
        }
    }
}