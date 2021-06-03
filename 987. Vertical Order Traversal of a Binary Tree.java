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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        /* 透過 BFS 一層一層尋遍，再將每一層擁有相同 X 軸的節點，紀錄並進行排序
         * 當該層結束後，將該層結果加入到總結果內即可，接著再進行下一層的計算與搜尋
         */
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        /* 記錄該層節點 */
        ArrayList<TreeNode> queue = new ArrayList<>();
        /* 紀錄該層節點相對的 X 軸*/
        ArrayList<Integer> xs = new ArrayList<>();
        queue.add(root);
        xs.add(0);
        BFS(queue, xs, map);
        /* 總結果從小排至大 */
        int[] nums = new int[map.size()];
        int count = 0;
        for(int num : map.keySet()) {
            nums[count] = num;
            count++;
        }
        Arrays.sort(nums);
        for(int num : nums) {
            result.add(map.get(num));
        }
        return result;
    }
    public void BFS(ArrayList<TreeNode> queue, ArrayList<Integer> xs, HashMap<Integer, List<Integer>> map) {
        ArrayList<TreeNode> newQueue = new ArrayList<>();
        ArrayList<Integer> newXS = new ArrayList<>();
        /* 紀錄當前階層的具有相同 X 軸的數字，並進行排序 */
        HashMap<Integer, List<Integer>> position = new HashMap<>();
        
        for(int i = 0;i<queue.size();i++) {
            int x = xs.get(i);
            TreeNode node = queue.get(i);
            if(position.containsKey(x)) {
                List<Integer> list = position.get(x);
                list.add(node.val);
                position.put(x, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                position.put(x, list);
            }
            if(node.left != null) {
                newQueue.add(node.left);
                newXS.add(x-1);
            }
            if(node.right != null) {
                newQueue.add(node.right);
                newXS.add(x+1);
            }
        }
        
        /* 將當前階層的紀錄，排序後，加入到總結果中 */
        for(int now : position.keySet()) {
            List<Integer> sort = position.get(now);
            Collections.sort(sort);
            if(map.containsKey(now)) {
                List<Integer> list = map.get(now);
                for(int num : sort) {
                    list.add(num);
                }
                map.put(now, list);
            } else {
                List<Integer> list = new ArrayList<>();
                for(int num : sort) {
                    list.add(num);
                }
                map.put(now, list);
            }
        }
        if(newQueue.size() != 0) {
            BFS(newQueue, newXS, map);
        }
    }
}