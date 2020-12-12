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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return root;
        /* 紀錄所有最長的 paths，之後再將最長 paths 進行比對
         * 之後再比較相同的節點，任一條 path 節點開始不同時，
         * 代表前一個節點就是所有 path 的父節點，即為答案
         */
        ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();
        DFS(root, 1, path, paths);     
        
        if(paths.size() == 1) return paths.get(0).get(paths.get(0).size()-1);
        
        TreeNode result = null;
        for(int i = 0;i<paths.get(0).size();i++) {
            boolean isDiff = false;
            int val = paths.get(0).get(i).val;
            for(int j = 0;j<paths.size();j++) {
                if(val != paths.get(j).get(i).val) {
                    isDiff = true;
                    break;
                }
            }
            if(!isDiff) {
                result = paths.get(0).get(i);
            }
        }
        
        return result;
    }
    
    public void DFS(TreeNode root, int depth, ArrayList<TreeNode> path, ArrayList<ArrayList<TreeNode>> paths) {
        
        path.add(root);
        
        if(root.left != null) {
            ArrayList<TreeNode> newPath = new ArrayList<>(path);
            DFS(root.left, 1, newPath, paths);
        }
        if(root.right != null) {
            ArrayList<TreeNode> newPath = new ArrayList<>(path);
            DFS(root.right, 1, newPath, paths);
        }
        
        /* 到了該 path 的最後一個點，判斷儲存的 paths 是否低於目前 path 的長度
         * ，若是，則清空 paths 儲存陣列，並加入新的 path，若否則不加入
         * ，若剛好等於的話，則不清空 paths，直接加入新的 path
         */
        if(root.left == null && root.right == null) {
            if(paths.size() == 0) {
                paths.add(path);
            } else {
                if(paths.get(0).size() < path.size()) {
                    paths.clear();
                    paths.add(path);
                } else if(paths.get(0).size() == path.size()) {
                    paths.add(path);
                }
            }
        }
    }
}