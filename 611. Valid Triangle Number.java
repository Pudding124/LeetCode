class Solution {
    public int triangleNumber(int[] nums) {
        /* 透過 3Sum 啟發，先將數列排序，將最大數(最後一位)固定 
         * 選定 頭與尾(最後一位的前一位)，相加是否大於最大數，符合則可以達到三角形原則(任兩邊相加大於第三邊)
         * 大於，加入目前頭尾數列大小，因頭往後移動任一相加皆大於最大數，之後尾往前一位，進行下一個組合判斷
         * 小於，頭往後一位，因尾為目前最大，若要更大，只能由頭增加
         * 頭尾相交，此次最大數的組合已尋找完成，最大數往前一位，進行下一輪的尋找
         * 最後可以得到結果
         */
        Arrays.sort(nums);
        if(nums.length < 3) return 0;
        int count = 0;
        int a = 0;
        int b = nums.length-2;
        int c = nums.length-1;
        System.out.println("--");
        while(c >= 2) {
            if((nums[a]+nums[b]) > nums[c]) {
                count += (b-a);
                b--;
            } else if((nums[a]+nums[b]) <= nums[c]) {
                a++;
            }
            
            if(a == b) {
                c--;
                a = 0;
                b = c-1;
            }
        }
        return count;
    }
}