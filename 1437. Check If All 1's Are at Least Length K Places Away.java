class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        /* 紀錄 0 的數量，當遇到 1 時，判斷 0 的數量是否大於 k ，並將 0 的數量重新計算即可
         * (除當開頭為 1 時，忽略開頭)
         */
        int place = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == 1 && i != 0) {
                if(place < k) {
                    return false;
                } else {
                    place = 0;
                }
            } else if(nums[i] == 0) {
                place++;
            }
        }
        return true;
    }
}