class Solution {
    public String minRemoveToMakeValid(String s) {
        /* 驗證括號是否合理，透過 Stack 後進先出，當遇到後括號時，消除一個前括號
         * 若無前括號，則該後括號不合理進行消除
         * 或是當檢視完所有字串後，仍有前括號剩餘，則消除剩餘無對應的前括號
         */
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            /* 消除不合理的後括號 */
            String word = s.substring(i, i+1);
            if(word.equals("(")) {
                stack.push(i);
            } else if(word.equals(")")) {
                if(stack.size() == 0) {
                    s = s.substring(0, i) + s.substring(i+1, s.length());
                    i--;
                } else {
                    stack.pop();
                }
            }
        }
        /* 消除不合理的前括號 */
        if(stack.size() > 0) {
            for(int i = 0;i<stack.size();i++) {
                s = s.substring(0, stack.get(i)-i) + s.substring(stack.get(i)+1-i, s.length());
            }
        }
        return s;
    }
}