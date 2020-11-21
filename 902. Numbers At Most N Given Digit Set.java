class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int result = 0;
        
        // 轉成 int 並排序
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        int[] digs = new int[digits.length];
        for(int i = 0;i<str.length();i++) {
            nums[i] = Integer.valueOf(str.substring(i, i+1));
        }
        
        for(int i = 0;i<digits.length;i++) {
            digs[i] = Integer.valueOf(digits[i]);
        }
        Arrays.sort(digs);
        
        // 計算最大位數，若大於該位數，表示後面的數字隨意排列皆會小於，因 10 > 1~9
        // 若等於就需在遞迴往下尋找其他數
        // 小於則直接不須考慮
        int count = 0;
        for(int i = 0;i<digs.length;i++) {
            if(nums[0] > digs[i]) {
                count += (int) Math.pow(digs.length, nums.length-1-0);
            } else if(nums[0] == digs[i]) {
                // 最後剩一位且剛好等於則為1
                if(nums.length == 1) {
                    count += 1;
                }else {
                    count += getInteger(nums, digs, 1);
                }
            }
        }
        
        result += count;
        
        // 除最大位數之後，都是排列
        for(int i = nums.length-1;i > 0;i--) {
            result += Math.pow(digs.length, i);       
        }
        return result;
    }
    
    public int getInteger(int[] nums, int[] digs, int index) {
        int count = 0;
        for(int i = 0;i<digs.length;i++) {
            if(nums[index] > digs[i]) {
                count += (int) Math.pow(digs.length, nums.length-1-index);
            } else if(nums[index] == digs[i]) {
                // 最後剩一位且剛好等於則為1
                if(nums.length == index+1) {
                    count += 1;
                }else {
                    count += getInteger(nums, digs, index+1);
                }
            }
        }
        return count;
    }
    
}