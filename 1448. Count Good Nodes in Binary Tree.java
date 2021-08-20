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
    public int goodNodes(TreeNode root) {
        /* 透過 DFS 歷遍每一點，紀錄路徑上目前最大的數值
         * 與當前節點比是否等於大於最大的數值，是的話則 +1
         */
        if(root == null) return 0;
        int[] result = new int[1];
        DFS(root, Integer.MIN_VALUE, result);
        return result[0];
    }
    
    public void DFS(TreeNode root, int max, int[] result) {
        
        if(max <= root.val) {
            result[0]++;
            max = Math.max(max, root.val);
        }
        
        if(root.left != null) {
            DFS(root.left, max, result);
        }
        if(root.right != null) {
            DFS(root.right, max, result);
        }
    }
}