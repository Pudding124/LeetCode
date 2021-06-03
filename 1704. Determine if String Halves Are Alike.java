class Solution {
    public boolean halvesAreAlike(String s) {
        /* 全部轉為小寫後，再檢查兩邊的母音數量即可 */
        s = s.toLowerCase();
        if(culVowel(s.substring(0, s.length()/2)) == culVowel(s.substring(s.length()/2, s.length()))) return true;
        return false;
    }
    
    public int culVowel(String str) {
        int result = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i) == 'a') {
                result++;
            } else if(str.charAt(i) == 'e') {
                result++;
            } else if(str.charAt(i) == 'i') {
                result++;
            } else if(str.charAt(i) == 'o') {
                result++;
            } else if(str.charAt(i) == 'u') {
                result++;
            }
        }
        return result;
    }
}