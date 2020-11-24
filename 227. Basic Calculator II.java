class Solution {
    public int calculate(String s) {
        // 消除空白
        s = s.replaceAll(" ", "");
        
        // 將數字與運算子分開
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> operations = new ArrayList<>();
        int start = 0;
        for(int i = 0;i<s.length();i++) {
            String word = s.substring(i, i+1);
            if(word.equals("/")) {
                nums.add(Integer.valueOf(s.substring(start, i)));
                operations.add(word);
                start = i+1;
            }else if(word.equals("*")) {
                nums.add(Integer.valueOf(s.substring(start, i)));
                operations.add(word);
                start = i+1;
            }else if(word.equals("+")) {
                nums.add(Integer.valueOf(s.substring(start, i)));
                operations.add(word);
                start = i+1;
            }else if(word.equals("-")) {
                nums.add(Integer.valueOf(s.substring(start, i)));
                operations.add(word);
                start = i+1;
            }
            
            if(i == s.length()-1) {
                nums.add(Integer.valueOf(s.substring(start, s.length())));
            }
        }
        
        // 先運算 * 與 /
        for(int i = 0;i<operations.size();i++) {
            if(operations.get(i).equals("/")) {
                operations.remove(i);
                nums.set(i+1, nums.get(i)/nums.get(i+1));
                nums.remove(i);
                i--;
            }else if(operations.get(i).equals("*")) {
                operations.remove(i);
                nums.set(i+1, nums.get(i)*nums.get(i+1));
                nums.remove(i);
                i--;
            }            
        }
        
        // 再運算 + 與 -
        for(int i = 0;i<operations.size();i++) {
            if(operations.get(i).equals("+")) {
                operations.remove(i);
                nums.set(i+1, nums.get(i)+nums.get(i+1));
                nums.remove(i);
                i--;
            }else if(operations.get(i).equals("-")) {
                operations.remove(i);
                nums.set(i+1, nums.get(i)-nums.get(i+1));
                nums.remove(i);
                i--;
            }
        }
        
        return nums.get(0);
    }
}