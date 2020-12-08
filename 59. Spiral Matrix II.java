class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 1) {
            result[0][0] = 1;
            return result;
        }
        int count = 1;
        int x = 0;
        int y = 0;
        int start = 0;
        int startLim = n % 2 == 0 ? (n/2)-1 : n/2;
        /*
         * 從外圈到內圈，依照規律繞完一圈
         * 當要移往下一圈時，起始位置 x 與 y 均遞增(0,0 ~ 1,1)
         * 且需計算每個不同長度需要繞幾圈
         */
        while(count < (n*n)+1) {
            if(x == start && y < n-start-1) {
                result[x][y] = count;
                count++;
                y++;
            } else if(y == n-start-1 && x < n-start-1) {
                result[x][y] = count;
                count++;
                x++;
            } else if(x == n-start-1 && y > start) {
                result[x][y] = count;
                count++;
                y--;
            } else if(y == start && x > start) {
                result[x][y] = count;
                count++;
                x--;
            }
            if(x == start && y == start && start < startLim) {
                start++;
                x = start;
                y = start;
                result[x][y] = count;
                y++;
                count++;
            }
        }
        return result;
    }
}