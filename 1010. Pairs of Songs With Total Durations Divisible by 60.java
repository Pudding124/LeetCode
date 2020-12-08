class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        /* 計算所有數的餘數，將相同餘數的擺在一起 */
        for(int i = 0;i<time.length;i++) {
            time[i] = time[i]%60;
            if(map.containsKey(time[i])) {
                map.put(time[i], map.get(time[i])+1);
            } else {
                map.put(time[i],1);
                list.add(time[i]);
            }
        }
        
        /* 之後計算只要相加可以被60整除，就可以相乘(組合)
         * 此外當本身為兩個以上時可以相互組合，如(0, 30)，則需要額外計算
         * 如2個為1個組合，3個為3個組合，可以發現以下規律。
         * 2    3    4     5 ....
         * 1 -> 3 -> 6 -> 10 ....
         *   +2   +3   +4    ....
         */
        for(int i = 0;i<list.size();i++) {
            if(map.get(list.get(i)) > 1 && (list.get(i)*2) % 60 == 0) {
                int dec = 1;
                for(int z = 2;z<map.get(list.get(i));z++) {
                    dec += z;
                }
                count += dec;
            }
            for(int j = i+1;j<list.size();j++) {
                if((list.get(i)+list.get(j)) % 60 == 0) {
                    count = count + (map.get(list.get(i))*map.get(list.get(j)));
                }
            }
        }
        return count;
    }
}