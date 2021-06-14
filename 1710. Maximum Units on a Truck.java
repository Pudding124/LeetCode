class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        /* 先從價值最高依序往下取，即可獲得結果 */
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<boxTypes.length;i++) {
            if(map.containsKey(boxTypes[i][1])) {
                map.put(boxTypes[i][1], map.get(boxTypes[i][1]) + boxTypes[i][0]);
            } else {
                map.put(boxTypes[i][1], boxTypes[i][0]);
                list.add(boxTypes[i][1]);
            }
        }
        int[] nums = new int[list.size()];
        for(int i = 0;i<list.size();i++) {
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        for(int i = nums.length-1;i>=0;i--) {
            int boxes = map.get(nums[i]);
            if(truckSize == 0) {
                break;
            } else if(truckSize >= boxes) {
                truckSize -= boxes;
                score += (boxes*nums[i]);
            } else if(truckSize < boxes) {
                score += (truckSize*nums[i]);
                truckSize = 0;
            }
        }
        return score;
    }
}