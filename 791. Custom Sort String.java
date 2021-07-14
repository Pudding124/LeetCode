class Solution {
    public String customSortString(String order, String str) {
        /* 透過 order 依序將 str 自拉出來組合到結果上，
         * 最後再將沒被拉到的剩餘字串加入到結果中即可
         */
        String result = "";
        for(int i = 0;i<order.length();i++) {
            String order_word = order.substring(i, i+1);
            for(int j = 0;j<str.length();j++) {
                String str_word = str.substring(j, j+1);
                if(str_word.equals(order_word)) {
                    result += str_word;
                    str = str.substring(0, j) + str.substring(j+1, str.length());
                    j--;
                }
            }
        }
        result += str;
        return result;
    }
}