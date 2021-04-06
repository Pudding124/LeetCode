class Solution {
    public int minOperations(int n) {
        /* 計算數組的中間值為最短距離，並從左邊計算與中間值的差值，
         * 最後加總全部差值即可
         */
        int result = 0;
        if(n%2 == 1) {
            int index = n/2;
            int num = (2 * index) + 1;
            for(int i = 1;i<num;i+=2) {
                result += (num-i);
            }
        } else {
            int index = n/2;
            int num = (2 * index);
            for(int i = 1;i<num;i+=2) {
                result += (num-i);
            }
        }
        return result;
    }
}