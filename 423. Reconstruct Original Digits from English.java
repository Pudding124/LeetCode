class Solution {
    public String originalDigits(String s) {
        List<Integer> record = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        /* 透過將每個數字的獨特字母作為辨識的標記，
         * 移除獨特字母時，也需移除會影響其他辨識的字母
         * 最後收集這些字母對應的數字，排序即可
         */
        // 0,4,6,8,5,7,3,2,9,1
        String[] unique = {"zero", "ufor", "xsi", "gheit", "fvie", "v", "h", "wo", "i", "o"};
        int[] uniqueNum = new int[]{ 0,4,6,8,5,7,3,2,9,1 }; 
        for(int i = 0;i<s.length();i++) {
            if(map.containsKey(s.substring(i,i+1))) {
                map.put(s.substring(i,i+1), map.get(s.substring(i,i+1))+1);
            } else {
                map.put(s.substring(i,i+1), 1);
            }
        }
        System.out.println(map);
        for(int i = 0;i<unique.length;i++) {
            if(!map.containsKey(unique[i].substring(0, 1)) || map.get(unique[i].substring(0, 1)) <= 0) continue;
            int num = map.get(unique[i].substring(0, 1));
            for(int j = 0;j<unique[i].length();j++) {
                map.put(unique[i].substring(j, j+1), map.get(unique[i].substring(j, j+1))-num);
            }
            for(int j = 0;j<num;j++) {
                record.add(uniqueNum[i]);
            }
        }
        
        int[] unsort = record.stream().mapToInt(i -> i).toArray();
        Arrays.sort(unsort);
        String result = "";
        for(int n : unsort) {
            result += String.valueOf(n);
        }
        return result;
    }
}