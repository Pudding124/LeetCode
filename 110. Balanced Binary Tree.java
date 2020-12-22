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
    public boolean isBalanced(TreeNode root) {
        /* 平衡二元樹 = 任一左右子樹相減不大於 1 */
        if(root == null) return true;
        boolean[] result = new boolean[1];
        DFS(root, result);
        return !result[0];
    }
    
    public int DFS(TreeNode root, boolean[] result) {
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = DFS(root.left, result);
        }
        if(root.right != null) {
            right = DFS(root.right, result);
        }
        /* 由 DFS 檢查該節點左右子樹相減是否大於 1 */
        if(Math.abs(left-right) > 1) {
            result[0] = true;
        }
        /* 若無左右子樹，則為葉，高度為 1 並回傳 */
        if(root.left == null && root.right == null) {
            return 1;
        }
        /* 當前節點高度則是取左右子節點最高為自己的高度 */
        return Math.max(left+1, right+1);
    }
}