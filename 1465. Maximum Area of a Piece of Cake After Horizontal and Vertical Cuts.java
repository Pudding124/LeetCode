class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        /* 收集橫列與縱列連續中最大的差值，相乘即可拿到總和 */
        
        long h_max = 0L;
        long w_max = 0L;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        List<Integer> h_list = new ArrayList<>();
        List<Integer> w_list = new ArrayList<>();

        h_list.add(0);
        w_list.add(0);
        
        for(int h_num : horizontalCuts) {
            h_list.add(h_num);
        }
        
        for(int w_num : verticalCuts) {
            w_list.add(w_num);
        }
        
        h_list.add(h);
        w_list.add(w);
        
        for(int i = 1;i<h_list.size();i++) {
            int tmp = h_list.get(i) - h_list.get(i-1);
            if(tmp > h_max) {
                h_max = tmp;
            }
        }
        
        for(int i = 1;i<w_list.size();i++) {
            int tmp = w_list.get(i) - w_list.get(i-1);
            if(tmp > w_max) {
                w_max = tmp;
            }
        }
        
        long result = ((h_max%1000000007) * (w_max%1000000007))%1000000007;
        return (int)result;
    }
}