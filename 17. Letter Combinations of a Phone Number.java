class Solution {
    public List<String> letterCombinations(String digits) {
        /* 根據每個字所有的組合，收集後依序往下組合 */
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        
        for(int i = 0;i<digits.length();i++) {
            String words = str[Integer.valueOf(digits.substring(i, i+1))-2];
            if(i == 0) {
                for(int j = 0;j<words.length();j++) {
                    result.add(words.substring(j, j+1));
                }
            } else {
                List<String> newResult = new ArrayList<>();
                for(String s : result) {
                    for(int j = 0;j<words.length();j++) {
                        String word = s + words.substring(j, j+1);
                        newResult.add(word);
                    }
                }
                result = newResult;
            }
        }
        return result;
    }
}