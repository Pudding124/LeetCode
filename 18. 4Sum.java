class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /* 與 3Sum 解法一致，多一層迴圈而已 */
        if(nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<String> record = new ArrayList<>();
        
        for(int i = nums.length-1;i>=3;i--) {
            int first = 0;
            int second = i-2;
            int third = i-1;
            while(third >= 2) {
                if((nums[first]+nums[second]+nums[third]+nums[i]) == target) {
                    List<Integer> item = new ArrayList<>();
                    String str = String.valueOf(nums[first]) +  String.valueOf(nums[second]) +  String.valueOf(nums[third]) +  String.valueOf(nums[i]);
                    if(!record.contains(str)) {
                        record.add(str);
                        item.add(nums[first]);
                        item.add(nums[second]);
                        item.add(nums[third]);
                        item.add(nums[i]);
                        result.add(item);
                    }
                    first++;
                    second--;
                } else if((nums[first]+nums[second]+nums[third]+nums[i]) > target) {
                    second--;
                } else if((nums[first]+nums[second]+nums[third]+nums[i]) < target) {
                    first++;
                }
                
                if(first >= second) {
                    third--;
                    first = 0;
                    second = third-1;
                }
            }
        }
        return result;
    }
}
