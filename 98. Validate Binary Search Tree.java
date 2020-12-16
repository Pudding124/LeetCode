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
    public boolean isValidBST(TreeNode root) {
        /* 使用中序收集TreeNode，若為 BST 會形成一個由小到大的陣列 */
        ArrayList<Integer> result = new ArrayList<>();
        DFS(root, result);
        
        for(int i = 0;i<result.size()-1;i++) {
            if(result.get(i) >= result.get(i+1)) return false;
        }
        return true;
    }
    
    public void DFS(TreeNode root, ArrayList<Integer> result) {
        if(root.left != null) DFS(root.left, result);
        result.add(root.val);
        if(root.right != null) DFS(root.right, result);
    }
}