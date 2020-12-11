class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        
        int count = 2;
        /* 計算前移次數 */
        int move = 0;
        /* 只要比對當前與當前的前兩個是否相同，若否，代表未重複，
         * 若相同代表會重複超過兩個，就需要前移蓋過重複的數值，
         * 且須紀錄前移次數，避免後面的數往前移時，仍被計算到。
         */
        for(int i = 2;i<nums.length-move;i++) {
            if(nums[i] != nums[i-2]) {
                count++;
            } else {
                // 前移
                for(int j = i;j<nums.length-1;j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                move++;
            }
        }
        return count;
    }
}