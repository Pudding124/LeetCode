class Solution {
    public int countSubstrings(String s) {
        /* 繞過所有組合，再透過比對即可
         * 比對部分，將字串切成兩半，並將後段翻轉
         * 並直接比對前段與後段是否相同
         */
        if(s.length() == 0) return 0;
        int result = s.length();
        for(int i = 2;i<=s.length();i++) {
            for(int j = 0;j<s.length();j++) {
                if((j+i) <= s.length() && checkPalindrome(s.substring(j, j+i))) {
                    result++;
                }
            }
        }
        return result;
    }
    
    public boolean checkPalindrome(String word) {
        if(word.length()%2 == 1) {
            String A = word.substring(0, word.length()/2+1);
            String B = new StringBuffer(word.substring(word.length()/2, word.length())).reverse().toString();
            return A.equals(B);
        } else {
            String A = word.substring(0, word.length()/2 == 0 ? 1 : word.length()/2);
            String B = new StringBuffer(word.substring(word.length()/2, word.length())).reverse().toString();
            return A.equals(B);
        }
    }
}