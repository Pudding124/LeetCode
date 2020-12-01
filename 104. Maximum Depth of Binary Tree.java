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
    public int maxDepth(TreeNode root) {
        /* 
         * 使用 BFS 依序往下檢查每一層，並計算層數
         */
        if(root == null) return 0;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        return BFS(queue, 1); 
    }
    
    public int BFS(ArrayList<TreeNode> queue, int result) {
        
        ArrayList<TreeNode> newQueue = new ArrayList<>();
        for(TreeNode node : queue) {
            if(node.left != null) {
                newQueue.add(node.left);
            }
            if(node.right != null) {
                newQueue.add(node.right);
            }
        }
        
        if(newQueue.size() != 0) {
            result = BFS(newQueue, result+1); 
        }
        return result;
    }
}