class Solution {
    public int nextGreaterElement(int n) {
        
        /* 發現規律，由最後一位數依序往前尋找，若有任一數大於當前數，且該任一數為最小大於數，如
         * 2433 -> 當前數為 2，4 與 3 皆大於 2，取最小大於數，則會取 3
         * 與其進行交換後，將當前數以後的所有位數由小到大排列，即可獲得答案，如
         * 2433 -> 3423 or 3432 皆可 -> 進行排列 -> 3234 即為答案
         */
        
        String str = String.valueOf(n);
        int[] nums = new int[str.length()];
        for(int i = 0;i<str.length();i++) {
            nums[i] = Integer.valueOf(str.substring(i, i+1));
        }
        
        /* 判斷是否有進行交換，若無則當前為最小，回傳A -1 */
        boolean flag = false;
        
        /* 由最後一位數依序往前尋找，若有任一數大於當前數，且該任一數為最小大於數 */
        int start = nums.length-1;
        int index = 0;
        for(int i = nums.length-2;i>=0;i--) {
            int minMaxIndex = -1;
            for(int j = i;j<nums.length;j++) {
                if(nums[i] < nums[j]) {
                    if(minMaxIndex == -1) {
                        minMaxIndex = j;
                        flag = true;
                    } else if(nums[minMaxIndex] > nums[j]) {
                        minMaxIndex = j;
                        flag = true;
                    }
                }
            }
            if(flag) {
                int tmp = nums[i];
                nums[i] = nums[minMaxIndex];
                nums[minMaxIndex] = tmp;
                index = i;
                break;
            }
        }
        
        
        if(!flag) {
            return -1;
        }
        
        String result = "";
        
        /* 與其進行交換後，將當前數以後的所有位數由小到大排列 */
        int[] unsorted = new int[nums.length-1-index];
        for(int i = index+1;i<nums.length;i++) {
            unsorted[i-index-1] = nums[i];
        }
        Arrays.sort(unsorted);
        
        for(int i = 0;i<=index;i++) {
            result += String.valueOf(nums[i]);
        }
        
        for(int sorted : unsorted) {
            result += String.valueOf(sorted);
        }
        
        /* 判斷是否大於 2^31 - 1 */
        if(Long.valueOf(result) > 2147483647) {
            return -1;
        }
        
        return Integer.valueOf(result);
    }
}