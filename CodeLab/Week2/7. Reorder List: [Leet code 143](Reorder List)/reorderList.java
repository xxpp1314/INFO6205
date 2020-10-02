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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode fastcur = slow.next;
        slow.next = null;
        ListNode pre = new ListNode(0);
        while(fastcur != null){
            ListNode next = fastcur.next;
            fastcur.next = pre.next;
            pre.next = fastcur;
            fastcur = next;
        }
        ListNode cur = head;
        ListNode backcur = pre.next;
        while(backcur != null){
            ListNode curnext = cur.next;
            ListNode backcurnext = backcur.next;
            cur.next = backcur;
            backcur.next = curnext;
            cur = curnext;
            backcur = backcurnext;
        }
    }
}
