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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;
        // 透過中序，收集所有數，會成為一個小到大的陣列
        ArrayList<Integer> nodes = new ArrayList<>();
        
        DFS(root, nodes);
        
        // 紀錄新 root 節點，並將收集的陣列組合成新的樹
        TreeNode newRoot = new TreeNode();
        TreeNode head = newRoot;
        for(int i = 0;i<nodes.size();i++) {
            if(i == 0) {
                newRoot.val = nodes.get(i);
            } else {
                newRoot.right = new TreeNode(nodes.get(i));
                newRoot = newRoot.right;
            }
        }
        
        return head;
    }
    
    public void DFS(TreeNode root, ArrayList<Integer> nodes) {
        // 左
        if(root.left != null) {
            DFS(root.left, nodes);
        }
        
        // 中
        nodes.add(root.val);
        
        // 右
        if(root.right != null) {
            DFS(root.right, nodes);
        }
    }
}