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
    public List<Double> averageOfLevels(TreeNode root) {
        /* 透過 BFS 收集每一層節點，將其值平均後，放入結果列表中 */
        List<Double> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        if(queue.size() > 0) {
            BFS(queue, result);
        }
        return result;
    }
    
    public void BFS(ArrayList<TreeNode> queue, List<Double> result) {
        Double sum = 0.0;
        int count = 0;
        ArrayList<TreeNode> newQueue = new ArrayList<>();
        for(TreeNode node : queue) {
            sum += node.val;
            count++;
            if(node.left != null) {
                newQueue.add(node.left);
            }
            if(node.right != null) {
                newQueue.add(node.right);
            }
        }
        result.add(sum/count);
        if(newQueue.size() > 0) {
            BFS(newQueue, result);
        }
    }
}