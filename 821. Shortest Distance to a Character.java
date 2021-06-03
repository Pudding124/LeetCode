class Solution {
    public int[] shortestToChar(String s, char c) {
        /* 
         * 先將所有尋找的詞彙定義為 0，其餘都是 -1 
         * 之後從 0 開始往旁邊擴散到 -1 的地方，依序將擴展數字變大
         * 最後當全部都不是 -1 後，即可回傳結果
         */
        int[] result = new int[s.length()];
        for(int i = 0;i<result.length;i++) {
            result[i] = -1;
        }
        int index = s.indexOf(String.valueOf(c));
        while(index >= 0) {
            result[index] = 0;
            index = s.indexOf(String.valueOf(c), index + 1);
        }
        
        int count = 0;
        while(true) {
            boolean flag = true;
            for(int i = 0;i<result.length;i++) {
                /* 
                 * 當前值為 -1 時，查看前後是否有非 -1，且為當前可被擴展之數字(避免持續變大)
                 * 就可以將 -1 轉為被擴展數字 +1
                 */
                if(result[i] == -1) {
                    if((i-1) >= 0 && result[i-1] != -1 && result[i-1] == count) {
                        result[i] = result[i-1]+1;
                        flag = false;
                    } else if((i+1) < result.length && result[i+1] != -1 && result[i+1] == count) {
                        result[i] = result[i+1]+1;
                        flag = false;
                    }
                }
            }
            count++;
            if(flag) break;
        }
        return result;
    }
}