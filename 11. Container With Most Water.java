class Solution {
    public int maxArea(int[] height) {
        /* 依序計算每個間格與高度組合，即可獲得結果 */
        int max = 0;
        for(int i = 0;i < height.length;i++) {
            for(int j = height.length-1;j > i;j--) {
                int h = Math.min(height[i], height[j]);
                int w = j-i;
                if((h*w) > max) {
                    max = h*w;
                }
            }
        }
        return max;
    }
}