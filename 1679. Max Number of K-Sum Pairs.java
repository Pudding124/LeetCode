class Solution {
    public int maxOperations(int[] nums, int k) {
        /* 由小排至大，可藉由算出差值，進而減少縮小範圍 */
        Arrays.sort(nums);
        
        /* 收集不重複之數字 */
        ArrayList<Integer> record = new ArrayList<>();
        
        /* 統計所有數字與其數量 */
        HashMap<Integer, Integer> list = new HashMap<>();
        for(int num : nums) {
            if(!list.containsKey(num)) {
                record.add(num);
                list.put(num, 1);
            } else {
                list.put(num, list.get(num)+1);
            }
        }
        
        int count = 0;
        int len = record.size()%2 == 0 ? record.size()/2 : (record.size()/2)+1;
        for(int i = 0;i<len;i++) {
            /* 判斷是否有相加剛好等於K的相對應數存在 */
            if(list.containsKey(k-record.get(i))) {
                /* 避免數字相同 */
                if(record.get(i) == (k-record.get(i))) {
                    count += list.get(record.get(i))/2;
                } else {
                    count += Math.min(list.get(record.get(i)), list.get(k-record.get(i)));
                }
                /* 數字遞增，相對應的數會遞減，故可以將搜索範圍變小 */
                len = record.indexOf(k-record.get(i));
            }
        }
        return count;
    }
}