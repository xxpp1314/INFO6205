/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        int reminder = n % k;
        int num = n / k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for(int i = 0; i < k && cur != null; i++){
            res[i] = cur;
            int curNum = num;
            if(reminder > 0){
                curNum = curNum + 1;
                reminder--;
            }
            for(int j = 0; j < curNum - 1; j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
