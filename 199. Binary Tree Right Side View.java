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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        BFS(queue, result);
        return result;
    }
    /* 透過 BFS 尋遍每一層，每一層最後一位，即是最右邊可看到的節點 */
    public void BFS(List<TreeNode> queue, List<Integer> result) {
        List<TreeNode> newQueue = new ArrayList<>();
        
        /* 收集 queue 最後一位數，即為最右邊的數 */
        if(queue.size() > 0) result.add(queue.get(queue.size()-1).val);
        
        for(int i = 0;i<queue.size();i++) {
            TreeNode node = queue.get(i);
            if(node.left != null) {
                newQueue.add(node.left);
            }
            if(node.right != null) {
                newQueue.add(node.right);
            }
        }
        if(newQueue.size() > 0) {
            BFS(newQueue, result);
        }
    }
}