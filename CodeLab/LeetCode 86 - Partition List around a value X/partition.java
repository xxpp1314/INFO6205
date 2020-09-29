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
    public ListNode partition(ListNode head, int x) {
        ListNode firsthead = new ListNode(0);
        ListNode first = firsthead;
        ListNode secondhead = new ListNode(0);
        ListNode second = secondhead;
        while(head != null){
            if(head.val < x){
                first.next = head;
                first = first.next;
            }
            else{
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = secondhead.next;
        return firsthead.next;
        
    }
}
