/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        /* 因樹狀結構是一模一樣的，original 與 cloned 同時尋找，
         * 當 original 找到時，return cloned
         */
        Object[] result = new Object[1];
        DFS(original, cloned, target, result);
        return (TreeNode) result[0];
    }
    
    public void DFS(TreeNode original, TreeNode cloned, TreeNode target, Object[] result) {
        if(original == target) {
            result[0] = cloned;
        } else {
            if(original.left != null) {
                DFS(original.left, cloned.left, target, result);
            }
            if(original.right != null) {
                DFS(original.right, cloned.right, target, result);
            }
        }
    }
}