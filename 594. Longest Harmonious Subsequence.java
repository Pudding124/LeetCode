class Solution {
    public int findLHS(int[] nums) {
        /* 記錄所有數的數量，並排序 */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        
        /* 紀錄差距 1 的相加最大數量 */
        int max = 0;
        /* 判斷是否為第一個數 */
        boolean flag = false;
        /* 記錄前一個數，與當前的數進行比較，看差距是否為 1 */
        int preNum = 0;
        for(int num : map.keySet()) {
            int sum = 0;
            if(!flag) {
                flag = true;
            } else {
                if((num-preNum) == 1) {
                    sum = map.get(num) + map.get(preNum);
                }
            }
            preNum = num;
            if(max < sum) {
                max = sum;
            }
        }
        return max;
    }
}