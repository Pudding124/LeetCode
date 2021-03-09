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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return null;
        /* 深度為 1，建立新root，並將原樹變為左子樹 */
        if(root != null && d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        /* 透過 BFS 尋找指定深度，當遇到下一層為指定深度時，
         * 就可以將當前節點接上新節點，當前節點的子節點，
         * 則變新節點的對應子節點
         */
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        BFS(queue, v, d, 1);
        return root;
    }
    
    public void BFS(List<TreeNode> queue, int value, int depth, int nowDepth) {
        if(nowDepth == depth-1) {
            for(TreeNode node : queue) {
                if(node.left != null) {
                    TreeNode newNode = new TreeNode(value);
                    TreeNode left = node.left;
                    node.left = newNode;
                    newNode.left = left;
                } else {
                    TreeNode newNode = new TreeNode(value);
                    node.left = newNode;
                }
                if(node.right != null) {
                    TreeNode newNode = new TreeNode(value);
                    TreeNode right = node.right;
                    node.right = newNode;
                    newNode.right = right;
                } else {
                    TreeNode newNode = new TreeNode(value);
                    node.right = newNode;
                }
            }
        } else {
            List<TreeNode> newQueue = new ArrayList<>();
            for(TreeNode node : queue) {
                if(node.left != null) {
                    newQueue.add(node.left);
                }
                if(node.right != null) {
                    newQueue.add(node.right);
                }
            }
            if(newQueue.size() > 0) {
                BFS(newQueue, value, depth, nowDepth+1);
            }
        }
    }
}