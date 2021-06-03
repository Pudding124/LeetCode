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
    public TreeNode convertBST(TreeNode root) {
        int[] temp = new int[1];
        if(root != null) DFS(root, temp);
        return root;
    }
    /* 依序 右 中 左 順序，依序累加，即可完成 */
    public void DFS(TreeNode root, int[] temp) {
        if(root.right != null) {
            DFS(root.right, temp);
        }
        
        temp[0] += root.val;
        root.val = temp[0];
        
        if(root.left != null) {
            DFS(root.left, temp);
        }
    }
}