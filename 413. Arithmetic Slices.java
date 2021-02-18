class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        /* 最小需要三個數組成序列 */
        if(A.length < 3) return 0;
        /* 紀錄結果 */
        int result = 0;
        /* 紀錄目前序列個數 */
        int count = 2;
        /* 紀錄序列差值 */
        int dis = A[1]-A[0];
        for(int i = 2;i<A.length;i++) {
            /* 當目前值-前一個值 == 差值，代表當前值屬於該序列 */
            if(A[i]-A[i-1] == dis) {
                count++;
            }
            /* 當目前值-前一個值 != 差值，代表當前值不屬於該序列
             * 更換差值，並將目前序列個數加入結果(規律上升)，
             * 之後重新記錄差值與序列個數
             * Note : 當陣列結束時，需結算序列個數
             */
            if(A[i]-A[i-1] != dis || i == A.length-1) {
                if(count >= 3) {
                    int tmp = 0;
                    int num = 1;
                    for(int j = count;j>=3;j--) {
                        tmp += num;
                        num++;
                    }
                    result += tmp;
                }
                dis = A[i]-A[i-1];
                count = 2;
            }
        }
        return result;
    }
}