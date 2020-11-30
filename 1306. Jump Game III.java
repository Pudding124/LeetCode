class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr.length == 0) return false;
    
        ArrayList<Integer> record = new ArrayList<>();
        boolean[] result = new boolean[1];
        DFS(arr, record, start, result);
        return result[0];
    }
    
    public void DFS(int[] arr, ArrayList<Integer> record, int index, boolean[] result) {
        // 判斷是否有重複走過的點，若走過代表會進入無窮迴圈
        if(!record.contains(index)) {
            // 加後的索引(index)，需在包含在陣列中
            if((index+arr[index]) >= 0 && (index+arr[index]) < arr.length) {
                ArrayList<Integer> newRecord = new ArrayList<>(record);
                // 若下個索引值為0，則不繼續執行，否則往下執行
                if(arr[index+arr[index]] == 0) {
                    result[0] = true;
                }else if(!result[0]) {
                    newRecord.add(index);
                    DFS(arr, newRecord, index+arr[index], result);
                }
            }
            // 減後的索引(index)，需在包含在陣列中
            if((index-arr[index]) >= 0 && (index-arr[index]) < arr.length) {
                ArrayList<Integer> newRecord = new ArrayList<>(record); 
                if(arr[index-arr[index]] == 0) {
                    result[0] = true;
                }else if(!result[0]) {
                    newRecord.add(index);
                    DFS(arr, newRecord, index-arr[index], result);
                }
            }
        }
    }
}