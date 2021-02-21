class Solution {
    public int romanToInt(String s) {
        /* 
         * 由後面往前查，當遇到字就查字的順序是否比紀錄的索引小，
         * 若小於索引，則減去該字，若大於等於，則加上該字的值，並更新紀錄的索引
         */
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        list.add("I");
        list.add("V");
        list.add("X");
        list.add("L");
        list.add("C");
        list.add("D");
        list.add("M");
        int index = list.indexOf(s.substring(s.length()-1, s.length()));
        int result = 0;
        for(int i = s.length();i>0;i--) {
            String word = s.substring(i-1, i);
            int num = list.indexOf(word);
            if(num >= index) {
                result += map.get(word);
                index = num;
            } else {
                result -= map.get(word);
            }
        }
        return result;
    }
}