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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* 透過 BST 特性，左子樹小於父節點，右子樹大於父節點 
         * 當 q 與 p 皆小於目前節點，代表都皆在當前節點的左子樹，移動至左子樹
         * 當 q 與 p 皆大於目前節點，代表都皆在當前節點的右子樹，移動至右子樹
         * 當 q < root 且 p > root，代表一個在左子樹，一個在右子樹，其共同節點必是目前節點
         * 當 q 或是 p 為當前節點時，代表另一節點必在自己子輩，故自己為共同節點
         */
        
        int min = p.val > q.val ? q.val : p.val;
        int max = p.val > q.val ? p.val : q.val;
        
        while(root != null) { 
            if(root.val == min || root.val == max) {
                return root;
            } else if(root.val > min && root.val < max) {
                return root;
            } else if(root.val > min && root.val > max) {
                root = root.left;
            } else if(root.val < min && root.val < max) {
                root = root.right;
            }   
        }
        return root;
    }
}