class Solution {
    public boolean hasAllCodes(String s, int k) {
        /* 根據 s 字串依序尋找 k 長度的字串，觀察是否有小於 2^k
         * 若有，則將結果收集起來，若收集總數與 2^k 相同，即為 true
         */
        HashSet<Integer> record = new HashSet<>();
        for(int i = 0;i<s.length()-k+1;i++) {
            String str = s.substring(i, i+k);
            int num = Integer.parseInt(str,2);
            if(num < Math.pow(2, k)) {
                record.add(num);
            }
        }
        
        return record.size() == Math.pow(2, k);
    }
}