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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while(n != 0){
            start = start.next;
            n--;
        }
        while(start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
