class Solution {
    public int minimumLengthEncoding(String[] words) {
        /* 比較是否有詞彙存在於其餘詞彙的尾段，若有則記錄最長的字彙
         * 若無則記錄該詞彙，最後計算所有詞彙長度與詞彙數量進行加總
         */
        ArrayList<String> record = new ArrayList<>();
        int result = 0;
        for(int i = 0;i<words.length;i++) {
            boolean flag = true;
            String word = words[i];
            String word2 = "";
            for(int j = 0;j<words.length;j++) {
                int index = words[j].lastIndexOf(word);
                if(index != -1 && i != j && (index+word.length()) == words[j].length()) {
                    flag = false;
                    word2 = words[j];
                    break;
                }
            }
            if(flag) {
                if(!record.contains(word)) record.add(word);
            } else {
                if(word.length() >= word2.length()) {
                    if(!record.contains(word)) record.add(word);
                } else {
                    if(!record.contains(word2)) record.add(word2);
                }
            }
        }
        for(String str : record) {
            result += str.length();
        }
        
        return result + record.size();
    }
}