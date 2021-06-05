class Solution {
    public int openLock(String[] deadends, String target) {
        /* 每一個點會有八條路，將每條路透過 BFS 一條一條走下去，
         * 並記錄走過的路，遇到節點時判斷是否為不能走的路與走過的路，
         * 當走到 target 即可回傳
         */
        List<String> queue = new ArrayList<>();
        HashSet<String> record = new HashSet<>();
        HashSet<String> deads = new HashSet<>();
        int count = 0;
        for(String dead : deadends) {
            deads.add(dead);
        }
        if(deads.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        queue.add("0000");
        
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i = 0 ;i<size;i++) {
                String com = queue.get(0);
                for(int j = 0 ;j<com.length();j++) {
                    int wordnum = Integer.valueOf(com.substring(j, j+1))+10;
                    String prev = com.substring(0, j) + String.valueOf((wordnum+1)%10) +       com.substring(j+1, com.length());
                    String next = com.substring(0, j) + String.valueOf((wordnum-1)%10) + com.substring(j+1, com.length());
                    
                    if(!deads.contains(prev) && !record.contains(prev)) {
                        queue.add(prev);
                        record.add(prev);
                    }
                    if(!deads.contains(next) && !record.contains(next)) {
                        queue.add(next);
                        record.add(next);
                    }

                    if(prev.equals(target) || next.equals(target)) {
                        return count + 1;
                    } 
                }
                queue.remove(0);
            }
            count++;
        }
        return -1;
    }
}