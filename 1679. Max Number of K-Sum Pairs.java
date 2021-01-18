class Solution {
    public int maxOperations(int[] nums, int k) {
        /* 紀錄使用過的數字 */
        ArrayList<Integer> record = new ArrayList<>();
        
        /* 統計所有數字與其數量 */
        HashMap<Integer, Integer> list = new HashMap<>();
        for(int num : nums) {
            if(!list.containsKey(num)) {
                list.put(num, 1);
            } else {
                list.put(num, list.get(num)+1);
            }
        }
        
        /* 由小排至大，故只需要檢查陣列前半段即可 */
        Arrays.sort(nums);
        
        int count = 0;
        for(int i = 0;i<nums.length/2;i++) {
            if(!record.contains(nums[i])) {
                
                /* 判斷是否有相加剛好等於K的相對應數存在 */
                if(list.containsKey(k-nums[i])) {
                    /* 避免數字相同 */
                    if(nums[i] == (k-nums[i])) {
                        count += list.get(nums[i])/2;
                    } else {
                        count += Math.min(list.get(nums[i]), list.get(k-nums[i]));
                    }
                }
                
                record.add(nums[i]);
                record.add(k-nums[i]);
            }
        }
        return count;
    }
}