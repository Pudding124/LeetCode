class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++) {
            list.add(intervals[i]);
        }
        
        for(int i = 0;i<list.size();i++) {
            int[] A = list.get(i);
            for(int j = i+1;j<list.size();j++) {
                int[] B = list.get(j);
                if(B[0] <= A[1] && B[1] > A[1] && B[0] > A[0] && B[1] > A[0]) { // A尾 B頭
                    int[] newItem = new int[2];
                    newItem[0] = A[0];
                    newItem[1] = B[1];
                    /* 
                     ** 將當前range與比較range合併後，set回當前range，並移除被比較range，且須退回前一次的range，避免擴
                     ** 大range後，仍有其他的尚未比較range未被包含在其中 
                     */
                    list.set(i, newItem);
                    list.remove(j);
                    i--;
                    break;
                }else if(B[0] < A[1] && B[1] < A[1] && B[0] < A[0] && B[1] >= A[0]) { // A頭 B尾
                    int[] newItem = new int[2];
                    newItem[0] = B[0];
                    newItem[1] = A[1];
                    /* 
                     ** 將當前range與比較range合併後，set回當前range，並移除被比較range，且須退回前一次的range，避免擴
                     ** 大range後，仍有其他的尚未比較range未被包含在其中 
                     */
                    list.set(i, newItem);
                    list.remove(j);
                    i--;
                    break;
                }else if(A[0] <= B[0] && A[0] <= B[1] && A[1] >= B[0] && A[1] >= B[1]) { // A包含B
                    int[] newItem = new int[2];
                    newItem[0] = A[0];
                    newItem[1] = A[1];
                    /* 
                     ** 將當前range與比較range合併後，set回當前range，並移除被比較range，且須退回前一次的range，避免擴
                     ** 大range後，仍有其他的尚未比較range未被包含在其中 
                     */
                    list.set(i, newItem);
                    list.remove(j);
                    i--;
                    break;
                }else if(A[0] >= B[0] && A[1] >= B[0] && A[0] <= B[1] && A[1] <= B[1]) { // B包含A
                    int[] newItem = new int[2];
                    newItem[0] = B[0];
                    newItem[1] = B[1];
                    /* 
                     ** 將當前range與比較range合併後，set回當前range，並移除被比較range，且須退回前一次的range，避免擴
                     ** 大range後，仍有其他的尚未比較range未被包含在其中 
                     */
                    list.set(i, newItem);
                    list.remove(j);
                    i--;
                    break;
                }
            } 
        }
        
        int[][] result = new int[list.size()][2];
        for(int i = 0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}