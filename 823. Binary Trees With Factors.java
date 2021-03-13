class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        /* 由小到大，建立紀錄表紀錄陣列中每個數因數的樹組合總數 */
        HashMap<Integer, Long> record = new HashMap<>();
        Arrays.sort(arr);
        /* 避免數過大，使用 long 儲存 */
        long result = 0L;
        for(int i = 0;i<arr.length;i++) {
            long tmp = 1L;
            for(int j = 0;j<=i;j++) {
                /* 當該數有因數存在於紀錄表中，若是因數相同，將其對應的樹組合總數相乘，
                 * 若因數不同，則須在*2(因為可以對調)
                 * ex 18 -> [2,9] [3,6]
                 * 2 -> 1(一種樹)
                 * 3 -> 1
                 * 6 -> [2,3] -> 3
                 * 9 -> [3,3] -> 2
                 * 18 -> 故 1(要算自己) + 2*1*2 + 2*1*3 -> 1
                 */
                if(i == j) {
                    record.put(arr[i], tmp);
                    result += tmp;
                     /* 避免數過大，先將其 mod 10^9+7 */
                    result %= 1000000007;
                } else if(arr[i]%arr[j] == 0) {
                    int start = arr[j];
                    int end = arr[i]/arr[j];
                    if(record.containsKey(end) && end >= start) {
                        if(end == start) {
                            tmp = tmp + record.get(start)*record.get(end);
                        } else {
                            tmp = tmp + 2*record.get(start)*record.get(end);
                        }
                    }
                }
            }
        }
        return (int)result;
    }
}