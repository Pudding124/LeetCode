class Solution {
    public List<String> letterCasePermutation(String S) {
        /* 針對每個字依序檢查，若是字母則將當前的所有收集字串 * 2，
         * 一半加入小寫，另一半加入大寫，再彙整到結果內，
         * 若是數字，則將收集的所有字串加入該數字即可。
         */
        List<String> result = new ArrayList<>();
        for(int i = 0;i<S.length();i++) {
            char word = S.substring(i, i+1).charAt(0);
            if((word >= 65 && word <= 90) || (word >= 97 && word <= 122)) {
                String upper = String.valueOf(word).toUpperCase();
                String lower = String.valueOf(word).toLowerCase();
                if(result.size() > 0) {
                    List<String> newList = new ArrayList<>(result);
                    for(int j = 0;j < result.size();j++) {
                        String str = result.get(j) + upper;
                        result.set(j, str);
                    }
                    for(int j = 0;j < newList.size();j++) {
                        String str = newList.get(j) + lower;
                        newList.set(j, str);
                    }
                    result.addAll(newList);
                } else {
                    /* 一開始收集字串為空，需加入第一批字詞 */
                    result.add(upper);
                    result.add(lower);
                }
            } else {
                if(result.size() > 0) {
                    for(int j = 0;j < result.size();j++) {
                        String str = result.get(j) + String.valueOf(word);
                        result.set(j, str);
                    }
                } else {
                    /* 一開始收集字串為空，需加入第一批字詞 */
                    result.add(String.valueOf(word));
                }
            }
        }
        return result;
    }
}