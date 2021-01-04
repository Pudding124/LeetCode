class Solution {
    public int countArrangement(int n) {
        /* 先收集所有的數字，再看能排在當前位置的數字有哪些，
         * 依序放入 DFS 中，進行排序，最後收集所有排序即為答案。
         */
        int[] result = new int[1];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            nums.add(i);
        }
        DFS(nums, 1, result);
        return result[0];
    }
    
    public void DFS(ArrayList<Integer> nums, int index, int[] result) {
        for(int i = 0;i<nums.size();i++) {
            /* 判斷當前數字是否能排在該位置，若可以則創建一個新陣列，
             * 並在新陣列中移除該數，因該數字被排在目前位置了，然後繼續往下遞迴，
             * 直到所有數字都被排列後，將其加入結果。
             */
            if((nums.get(i)%index == 0) || (index%nums.get(i) == 0)) {
                ArrayList<Integer> newNums = new ArrayList<>(nums);
                newNums.remove(i);
                DFS(newNums, index+1, result);
            }
        }
        if(nums.size() == 0) {
            result[0]++;
        }
    }
}