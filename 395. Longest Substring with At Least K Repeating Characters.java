class Solution {
    public int longestSubstring(String s, int k) {
        // 先統計所有字詞出現的頻率
        HashMap<String, Integer> map = new HashMap<>();
        int[] result = new int[1];
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }else {
                map.put(word, map.get(word)+1);
            }
        }
        
        boolean flag = true;
        for(String key : map.keySet()) {
            // 當某字詞頻率小於K，代表該字串不可能包含該字詞，將該字詞當作切割點
            if(map.get(key) < k) {
                int start = 0;
                int index = s.indexOf(key);
                while(index >= 0) {
                    if(s.substring(start, index).length() >= k) DFS(s.substring(start, index), k, result);
                    start = index+1;
                    index = s.indexOf(key, index + 1);
                    if(index == -1) {
                        DFS(s.substring(start, s.length()), k, result);
                    }
                }
                flag = false;
                // 一次一詞，避免進入多次無意義迭代
                break;
            }
        }
        
        // 當無字詞頻率小於K，則可以將其比較是否為當前最常字串
        if(flag) {
            if(s.length() > result[0]) {
                result[0]  = s.length();
            }
        }
        
        return result[0];
    }
    
    public void DFS(String s, int k, int[] result) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }else {
                map.put(word, map.get(word)+1);
            }
        }
        boolean flag = true;
        // 當某字詞頻率小於K，代表該字串不可能包含該字詞，將該字詞當作切割點
        for(String key : map.keySet()) {
            if(map.get(key) < k) {
                int start = 0;
                int index = s.indexOf(key);
                while(index >= 0) {
                    if(s.substring(start, index).length() >= k) DFS(s.substring(start, index), k, result);
                    start = index+1;
                    index = s.indexOf(key, index + 1);
                    if(index == -1) {
                        DFS(s.substring(start, s.length()), k, result);
                    }
                }
                flag = false;
                // 一次一詞，避免進入多次無意義迭代
                break;
            }
        }
        
        // 當無字詞頻率小於K，則可以將其比較是否為當前最常字串
        if(flag) {
            if(s.length() > result[0]) {
                result[0]  = s.length();
            }
        }
    }
}