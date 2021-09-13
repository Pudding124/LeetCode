class Solution {
    public int maxNumberOfBalloons(String text) {
        /* 紀錄 balloon 的字母，若 l 或是 o 數量小於 2 代表不可能組成字串
         * 最後再將 l 與 o 數量除以 2，最後找最小的數量，即可得到結果
         */
        int[] nums = new int[5];
        for(int i = 0;i<text.length();i++) {
            String word = text.substring(i, i+1);
            if(word.equals("b")) {
                nums[0]++;
            } else if(word.equals("a")) {
                nums[1]++;
            } else if(word.equals("l")) {
                nums[2]++;
            } else if(word.equals("o")) {
                nums[3]++;
            } else if(word.equals("n")) {
                nums[4]++;
            }
        }
        
        if(nums[2] < 2) {
            return 0;
        } else {
            nums[2] = nums[2]/2;
        }
        
        if(nums[3] < 2) {
            return 0;
        } else {
            nums[3] = nums[3]/2;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}