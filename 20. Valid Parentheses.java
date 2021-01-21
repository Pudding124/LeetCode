class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        
        /* 透過 Stack 特性，先進後出，後進先出
         * 因遇到左括號時，皆須放入，遇到右括號，則需移出
         * 移除時，需比對最近的一次移入的是否為相對應的左括號
         */
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(word.equals("[")) {
                stack.push(word);
            } else if(word.equals("]")) {
                if(stack.size() > 0) {
                    String pop = stack.pop();
                    if(!pop.equals("[")) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if(word.equals("{")) {
                stack.push(word);
            } else if(word.equals("}")) {
                if(stack.size() > 0) {
                    String pop = stack.pop();
                    if(!pop.equals("{")) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if(word.equals("(")) {
                stack.push(word);
            } else if(word.equals(")")) {
                if(stack.size() > 0) {
                    String pop = stack.pop();
                    if(!pop.equals("(")) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(stack.size() == 0) {
            return true;
        }
        return false;
    }
}