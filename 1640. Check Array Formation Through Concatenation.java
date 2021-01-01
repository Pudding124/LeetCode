class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        /* 紀錄目前需尋找的數字位置 */
        int index = 0;
        while(index < arr.length) {
            /* 若沒有找到任何一個碎片堆的開頭相同的話，即返回 False */
            boolean flag = false;
            for(int i = 0;i<pieces.length;i++) {
                /* 判斷碎片堆中的第一個數字是否等於，是的話則繼續往下找，
                 * 若有其中一個不符則返回 False，因所有數字均為只有一個
                 */
                if(pieces[i][0] == arr[index]) {
                    flag = true;
                    for(int j = 0;j<pieces[i].length;j++) {
                        if(arr[index+j] != pieces[i][j]) {
                            return false;
                        }
                    }
                    index += pieces[i].length;
                    break;
                }
            }
            if(!flag) {
                return false;
            }
        }
        return true;
    }
}