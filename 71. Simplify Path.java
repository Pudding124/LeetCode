class Solution {
    public String simplifyPath(String path) {
        /* 回傳結果 */
        String result = "";
        /* 記錄所有檔案名稱 */
        ArrayList<String> paths = new ArrayList<>();
        int preIndex = 0;
        int curIndex = path.indexOf("/");
        while (true) {
            /* 當往下找沒有 / 後，需紀錄前一個 / 至該 path 的長度，避免最後一位不是 /
             * 導致有檔案名稱被少計算到
             */ 
            if(curIndex == -1) {
                String word = path.substring(preIndex, path.length());
                if(!word.equals("") && !word.equals(".") && !word.equals("..")) paths.add(word);
                if(word.equals("..")) {
                    if(paths.size() > 0) paths.remove(paths.size()-1);
                }
                break;
            }
            /* 記錄檔案名稱 */
            String word = path.substring(preIndex, curIndex);
            if(!word.equals("") && !word.equals(".") && !word.equals("..")) paths.add(word);
            /* 遇到 .. 移除最後一個檔案名稱 */
            if(word.equals("..")) {
                if(paths.size() > 0) paths.remove(paths.size()-1);
            }
            preIndex = curIndex + 1;
            curIndex = path.indexOf("/", curIndex + 1);
        }
        /* 統整結果 */
        for(String word : paths) {
            result += "/";
            result += word;
        }
        return result.length() == 0 ? "/" : result;
    }
}