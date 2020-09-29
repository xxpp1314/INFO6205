/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
        }
        else{
            Node cur = head;
            while(!(cur.val <= insertVal && insertVal <= cur.next.val) && !(cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) && cur.next != head)
                cur = cur.next;
            Node pre = cur.next;
            cur.next = new Node(insertVal);
            cur.next.next = pre;
        }
        return head;
    }
}
