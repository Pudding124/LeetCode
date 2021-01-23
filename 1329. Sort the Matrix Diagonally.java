class Solution {
    public int[][] diagonalSort(int[][] mat) {
        /* 起始點皆是左邊與上邊，依序將 x 與 y 軸遞增，
         * 排序後，再將排序後的數值，塞入相對應的位置即可
         */
        /* 先從左邊開始 */
        for(int i = mat.length-1;i>=0;i--) {
            List<Integer> unsort = new ArrayList<>();
            int y = i;
            int x = 0;
            while(y <= (mat.length-1) && x <= (mat[0].length-1)) {
                unsort.add(mat[y][x]);
                y += 1;
                x += 1;
            }
            /* 排序收集到的數字 */
            int[] sort = new int[unsort.size()];
            for(int j = 0;j<unsort.size();j++) {
                sort[j] = unsort.get(j);
            }
            Arrays.sort(sort);
            
            /* 從頭開始放入排序後的數 */
            int tmp_y = i;
            int tmp_x = 0;
            int count = 0;
            while(tmp_y <= (mat.length-1) && tmp_x <= (mat[0].length-1)) {
                mat[tmp_y][tmp_x] = sort[count];
                tmp_y += 1;
                tmp_x += 1;
                count++;
            }
        }
        /* 從上邊開始 */
        for(int i = 1;i<mat[0].length;i++) {
            List<Integer> unsort = new ArrayList<>();
            int y = 0;
            int x = i;
            while(y <= (mat.length-1) && x <= (mat[0].length-1)) {
                unsort.add(mat[y][x]);
                y += 1;
                x += 1;
            }
            /* 排序收集到的數字 */
            int[] sort = new int[unsort.size()];
            for(int j = 0;j<unsort.size();j++) {
                sort[j] = unsort.get(j);
            }
            Arrays.sort(sort);
            
            /* 從頭開始放入排序後的數 */
            int tmp_y = 0;
            int tmp_x = i;
            int count = 0;
            while(tmp_y <= (mat.length-1) && tmp_x <= (mat[0].length-1)) {
                mat[tmp_y][tmp_x] = sort[count];
                tmp_y += 1;
                tmp_x += 1;
                count++;
            }
        }
        
        return mat;
    }
}