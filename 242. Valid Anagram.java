class Solution {
    public boolean isAnagram(String s, String t) {
        /* 使用一個 map 紀錄 s 出現過的詞與次數
         * 再用 t 的字詞去消除 map 對應詞的次數
         * 若 map 不存在 t 的字詞，則為 false
         * 或是減完 t 的字詞 map 還有剩，也是為 false
         */
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        
        for(int i = 0;i<t.length();i++) {
            String word = t.substring(i, i+1);
            if(map.containsKey(word)) {
                if(map.get(word) == 1) {
                    map.remove(word);
                } else {
                    map.put(word, map.get(word)-1);
                }
            } else {
                return false;
            }
        }
        
        if(map.size() != 0) return false;
        
        return true;
    }
}