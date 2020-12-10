class Solution {
    public boolean validMountainArray(int[] arr) {
        /* 小於三不構成一座山 */
        if(arr.length < 3) return false;
        /* 判斷是上升還是下降 */
        boolean goDown = false;
        for(int i = 0;i<arr.length-1;i++) {
            if(goDown) {
                if(arr[i] <= arr[i+1]) return false;
            } else {
                if(i == 0) {
                    /* 一開始若是下降，不構成一座山 */
                    if(arr[i] >= arr[i+1]) return false;
                } else {
                    if(arr[i] == arr[i+1]) return false;
                    /* 開始下降 */
                    if(arr[i] > arr[i+1]) goDown = true;
                }
            }
        }
        /* 從頭到尾都是上升，不構成一座山 */
        if(!goDown) return false;
        return true;
    }
}