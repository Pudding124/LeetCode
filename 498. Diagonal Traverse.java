class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        
        /* 紀錄 x, y 軸*/
        int x = 0;
        int y = 0;
        /* 判斷是否全部繞完 */
        int count = 0;
        /* 紀錄所有繞到的數字 */
        int[] result = new int[matrix.length*matrix[0].length];
        
        /* 判斷是往左下走 還是 往右上走*/
        boolean goTop = true;
        /* 判斷轉彎時，是往右轉還是往下轉 */
        boolean goRight = true;
        while(count < matrix.length*matrix[0].length) {
            result[count] = matrix[y][x];
            if(goTop) {
                x += 1;
                y -= 1;
            } else if(!goTop) {
                x -= 1;
                y += 1;
            }
            /* 判斷是否超出陣列，若超出陣列代表需要轉彎 */
            if(x < 0 || x == matrix[0].length || y < 0 || y == matrix.length) {
                /* 走過右就走下，若右不能走就走下，下一次再走右，同理
                 * 走過下就走右，若下不能走就走右，下一次再走下 
                 */
                if(goTop) {
                    x -= 1;
                    y += 1;
                    if(x+1 == matrix[0].length) {
                        y += 1;
                    } else {
                        x += 1;
                        goRight = !goRight;
                    }
                    goTop = !goTop;
                } else if(!goTop) {
                    x += 1;
                    y -= 1;
                    if(y+1 == matrix.length) {
                        x += 1;
                    } else {
                        y += 1;
                        goRight = !goRight;
                    }
                    goTop = !goTop;
                }
            }
            
            count++;
        }
        return result;
    }
}