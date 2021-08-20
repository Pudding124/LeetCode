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
    public int maxProduct(TreeNode root) {
        /* 透過 DFS 歷遍所有節點，記錄加總與記錄所有subtree
         * 依序將 subtree*(總和-subtree) 取最大即可
         */
        HashSet<Long> subTrees = new HashSet<>();
        long[] result = new long[1];
        DFS(root, subTrees, result);
        long max = 0L;
        for(long num : subTrees) {
            long sum = (num*(result[0]-num));
            if(max < sum) {
                max = sum;
            }
        }
        return (int) (max%1000000007L);
    }
    
    public long DFS(TreeNode root, HashSet<Long> subTrees, long[] result) {
        long tmp = root.val;
        if(root.left != null) {
            long num = DFS(root.left, subTrees, result);
            tmp += num;
        }
        if(root.right != null) {
            long num = DFS(root.right, subTrees, result);
            tmp += num;
        }
        
        subTrees.add(tmp);
        result[0] += root.val;
        return tmp;
    }
}