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
class BSTIterator {

    ArrayList<Integer> nodes = null;
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        /* 
         * 使用 DFS 並根據中序來找BST，會形成一個由小到大的陣列 
         * 之後當呼叫 next 時，移除第一筆即可
         */
        DFS(root, nodes);
    }
    
    public int next() {
        int num = nodes.get(0);
        nodes.remove(0);
        return num;
    }
    
    public boolean hasNext() {
        if(nodes.size() != 0) {
            return true;
        }
        return false;
    }
    
    public void DFS(TreeNode root, ArrayList<Integer> nodes) {
        if(root.left != null) {
            DFS(root.left, nodes);
        }
        
        nodes.add(root.val);
        
        if(root.right != null) {
            DFS(root.right, nodes);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */