class Solution {
    public int mirrorReflection(int p, int q) {
        // 9 2   // 10 3    // 7 2
        // 0 4   // 0 6     // 0 4
        // 9 6   // 10 9    // 7 6
        // 0 8   // 6.7 10  // 3.5 7
        // 4.5 9 // 0 8     // 0 6
        // 9 8   // 10 5    // 7 4
        // 0 6   // 0 2     // 0 2
        // 9 4   // 6.7 0   // 7 0
        // 0 2   // 10 1
        // 9 0   // 10 4
                 // 0 7
                 // 10 10

        /* 觀察規律，發現只要當 q > p 或 q < 0 就是到頂或到底產生折射，且會將超過的值減少或是增加到下次的折射位置 
           故只要記錄有折射到最後的次數即可
        */
        int currentY = 0;
        boolean flag = false;
        int remain = 0;
        int count = 0;
        boolean inMid = false;
        while(true) {
            
            if(count%2 == 1 && currentY == 0 && !inMid) {
                return 0;
            }else if(count%2 == 0 && currentY == p && !inMid) {
                return 2;
            }else if(count%2 == 1 && currentY == p && !inMid) {
                return 1;
            }
            
            if(inMid) {
                inMid = !inMid;
            }
            
            if(!flag) {
                currentY += remain;
                currentY += q;
                remain = 0;
                count++;
            }else {
                currentY -= remain;
                currentY -= q;
                remain = 0;
                count++;
            }
            
            // 判斷是否到頂或到底
            if(currentY > p) {
                remain = currentY - p;
                currentY = p;
                flag = true;
                // 去掉碰到頂部的折射
                count--;
                // 避免被判斷成碰到點
                inMid = true;
            }else if(currentY < 0) {
                remain = Math.abs(currentY);
                currentY = 0;
                flag = false;
                // 去掉碰到底部的折射
                count--;
                // 避免被判斷成碰到點
                inMid = true;
            }
            
        }
    }
}