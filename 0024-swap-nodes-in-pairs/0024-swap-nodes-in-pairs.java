/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode c1;
        ListNode c2;
        temp.next=head;

    while(temp.next!=null && temp.next.next!=null){
        c1=temp.next;
        c2=temp.next.next;
        c1.next=c2.next;
        c2.next=c1;
        temp.next=c2;
        temp=c1;
    }    
    return dummy.next;
    }
}