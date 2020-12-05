class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1) {
            if(n == 1 && flowerbed[0] == 0) {
                return true;
            }
            return false;
        }
        /*
         * 只要判斷目前、前一個與後一個是否為 1，若皆無則可以種花
         * 如果有其中一項有花的，就代表當前位置不能種花，繼續往下一個位置前進
         * 因為大於陣列部分，皆當作無種花，所以頭只需要注意目前與後一個
         * 尾只需要注意目前與前一個
         */
        for(int i = 0;i<flowerbed.length;i++) {
            if(i+1 < flowerbed.length && i-1 >= 0) {
                if(flowerbed[i] != 1 && flowerbed[i+1] != 1 && flowerbed[i-1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if(i+1 < flowerbed.length && i-1 < 0) {
                if(flowerbed[i] != 1 && flowerbed[i+1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if(i+1 == flowerbed.length && i-1 > 0) {
                if(flowerbed[i] != 1 && flowerbed[i-1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if(n <= 0) return true;
        return false;
    }
}