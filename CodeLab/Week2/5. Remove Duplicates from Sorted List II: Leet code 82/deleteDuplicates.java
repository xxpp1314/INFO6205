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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre != null && pre.next != null){
            ListNode cur = pre.next;
            if(cur.next == null || cur.next.val != cur.val)
                pre = cur;
            else{
                while(cur.next != null && cur.next.val == cur.val)
                    cur = cur.next;
                pre.next = cur.next;
            }
        }
        return dummyHead.next;
    }
}
