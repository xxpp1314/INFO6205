/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }
    
    public TreeNode dfs(TreeNode r1, TreeNode r2){
        if(r1 == null || r2 == null){
            return r1 == null ? r2 : r1;
        }
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }
}
//idea:recursion
