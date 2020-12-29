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
    public int pseudoPalindromicPaths (TreeNode root) {
        /* 記錄所有走過的 path ，並將 path 所經過的節點統計，相同的放在一起計算
         * 再來將每條 path 統計之節點數量%2，若要可以組成回文，最多只能有一個餘 1
         * 最後統計所有 path 就可以得到結果
         */
        ArrayList<HashMap<Integer, Integer>> paths = new ArrayList<>();
        HashMap<Integer, Integer> path = new HashMap<>();
        path.put(root.val, 1);
        DFS(paths, path, root);
        /* 記錄所有的伪回文 */
        int count = 0;
        for(HashMap<Integer, Integer> oldPath : paths) {
            int single = 0;
            for(int val : oldPath.keySet()) {
                if(oldPath.get(val)%2 == 1) {
                    single++;
                }
            }
            /* 最多只能有一個單數(餘 1) */
            if(single <= 1)count++; 
        }
        return count;
    }
    
    /* 歷遍所有 path */
    public void DFS(ArrayList<HashMap<Integer, Integer>> paths, HashMap<Integer, Integer> path, TreeNode root) {
        if(root.left != null) {
            HashMap<Integer, Integer> newPath = new HashMap<>(path);
            if(newPath.containsKey(root.left.val)) {
                newPath.put(root.left.val, newPath.get(root.left.val)+1);
            } else {
                newPath.put(root.left.val, 1);
            }
            DFS(paths, newPath, root.left);
        }
        if(root.right != null) {
            HashMap<Integer, Integer> newPath = new HashMap<>(path);
            if(newPath.containsKey(root.right.val)) {
                newPath.put(root.right.val, newPath.get(root.right.val)+1);
            } else {
                newPath.put(root.right.val, 1);
            }
            DFS(paths, newPath, root.right);
        }
        if(root.left == null && root.right == null) {
            paths.add(path);
        }
    }
}