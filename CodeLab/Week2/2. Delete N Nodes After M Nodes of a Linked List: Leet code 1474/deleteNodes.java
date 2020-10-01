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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if(head == null)
                return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode newlink = newhead;
        while(newlink != null){
            int continueNode = m;
            int deleteNode = n;
            while(continueNode > 0 && newlink != null){
                newlink = newlink.next;
                continueNode--;
            }
            while(deleteNode > 0 && newlink != null && newlink.next != null){
                newlink.next = newlink.next.next;
                deleteNode--;
            }
        }
        return head;
    }
}
