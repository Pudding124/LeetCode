class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /* 記錄所有數字與對應的索引
         * 最後再將紀錄的前 k 名，放入結果
         */
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[] result = new int[k];
        for(int i = 0;i<mat.length;i++) {
            int count = 0;
            for(int j = 0;j<mat[i].length;j++) {
                if(mat[i][j] == 1) count++;
            }
            if(map.containsKey(count)) {
                ArrayList<Integer> list = map.get(count);
                list.add(i);
                map.put(count, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(count, list);
            }
        }
        int index = 0;
        boolean flag = true;
        while (flag) {
            for(int key : map.keySet()) {
                ArrayList<Integer> list = map.get(key);
                for(int num : list) {
                    result[index] = num;
                    index++;
                    if(k == index) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    break;
                }
            }
        }
        return result;
    }
}