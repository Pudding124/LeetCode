class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> result = new HashSet<>();
        // 將字母對應到相對應的摩斯碼
        for(int i = 0;i<26;i++) {
            String alphabet = String.valueOf((char)(i+97));
            map.put(alphabet, morse[i]);
        }
        // 將字母換成摩斯密碼，並透過 HashSet 特性進行儲存，即可得到答案
        for(String word : words) {
            String str = "";
            for(int i = 0;i<word.length();i++) {
                str += map.get(word.substring(i, i+1));
            }
            result.add(str);
        }
        return result.size();
    }
}