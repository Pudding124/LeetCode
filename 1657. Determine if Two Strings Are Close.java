class Solution {
    public boolean closeStrings(String word1, String word2) {
        /* 記錄所有出現過的字與其出現的次數，只要 word1 與 word2 出現的字皆相同
         * 且出現的次數皆相同(不用相同數字，因可相互交換)
         */
        if(word1.length() != word2.length()) return false;
        HashMap<String, Integer> record_1 = new HashMap<>();
        HashMap<String, Integer> record_2 = new HashMap<>();
        for(int i = 0;i<word1.length();i++) {
            String str_1 = word1.substring(i, i+1);
            String str_2 = word2.substring(i, i+1);
            if(!record_1.containsKey(str_1)) {
                record_1.put(str_1, 1);
            } else {
                record_1.put(str_1, record_1.get(str_1)+1);
            }
            if(!record_2.containsKey(str_2)) {
                record_2.put(str_2, 1);
            } else {
                record_2.put(str_2, record_2.get(str_2)+1);
            }
        }
        
        if(record_1.size() != record_2.size()) return false;
        int[] num_1 = new int[record_1.size()];
        int[] num_2 = new int[record_2.size()];
        int count = 0;
        for(String str_1 : record_1.keySet()) {
            if(!record_2.containsKey(str_1)) {
               return false; 
            } else {
                num_1[count] = record_1.get(str_1);
                num_2[count] = record_2.get(str_1);
            }
            count++;
        }
        Arrays.sort(num_1);
        Arrays.sort(num_2);
        
        for(int i = 0;i<num_1.length;i++) {
            if(num_1[i] != num_2[i]) return false;
        }
        
        return true;
    }
}