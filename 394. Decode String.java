class Solution {
    // 由前往後，遇到數字時，將數字與陣列解析出來，丟入遞迴中(避免陣列中還有陣列)，並用迴圈包住
    //；遇到字則直接加入到結果。
    public String decodeString(String s) {
        String[] result = new String[1];
        
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(isInteger(word)) {
                int time = getInteger(s.substring(i, s.length()));
                int[] num = getArray(s.substring(i, s.length()));
                for(int j = 0;j<time;j++) {
                    // 丟入陣列內容(去除括號)，要加上當前index
                    recursive(result, s.substring(i+num[0]+1, i+num[1]-1));
                }
                // 跳至陣列結束位置，繼續往後檢查
                if(i+num[1]-1 < s.length()) i = i+num[1]-1;
            }else {
                result[0] += word;
            }
        }
        return result[0].substring(4,result[0].length());
    }
    
    // 解析陣列內容，若有其他陣列也在其中則會遞迴
    public void recursive(String[] result, String s) {
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(isInteger(word)) {
                int time = getInteger(s.substring(i, s.length()));
                int[] num = getArray(s.substring(i, s.length()));
                
                for(int j = 0;j<time;j++) {
                    recursive(result, s.substring(i+num[0]+1, i+num[1]-1));
                }
                if(num[1]-1 < s.length()) i = i+num[1]-1;
            }else {
                result[0] += word;
            }
        }
    }
    
    // 判斷是否為數字
    public boolean isInteger(String s) {
        char ch = s.charAt(0);
        if(ch >= 48 && ch <= 57) {
            return true;
        }
        return false;
    }
    
    // 回傳迴圈數量
    public int getInteger(String s) {
        for(int i = 0;i<s.length();i++) {
            if(s.substring(i, i+1).equals("[")) {
                return Integer.valueOf(s.substring(0, i));
            }
        }
        return 0;
    }
    
    // 尋找陣列起始與結束
    public int[] getArray(String s) {
        Stack<String> stack = new Stack();
        
        int[] num = new int[2];
        boolean flag = true;
        for(int i = 0;i<s.length();i++) {
            if(s.substring(i, i+1).equals("[")) {
                stack.push("[");
                if(flag) {
                    flag = false;
                    num[0] = i;
                }
            }else if(s.substring(i, i+1).equals("]")) {
                stack.pop();
                if(stack.size() == 0) {
                    num[1] = i+1;
                    return num;
                }
            }
        }
        return num;
    }
    
}