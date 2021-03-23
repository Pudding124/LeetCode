class Solution {
    public int threeSumMulti(int[] arr, int target) {
        /* 透過固定一個數與兩個指標，搜尋出所有組合，
         * 再算出所有排列組合的方法即可
         */
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> list = new HashSet<>();
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++) {
            String key = String.valueOf(arr[i]);
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
            
            int tmp = target - arr[i];
            int start = i+1;
            int end = arr.length-1;
            
            while(start < end) {
                if(tmp == (arr[start]+arr[end])) {
list.add(String.valueOf(arr[i])+","+String.valueOf(arr[start])+","+String.valueOf(arr[end]));
                    start++;
                    end--;
                } else if(tmp > (arr[start]+arr[end])) {
                    start++;
                } else if(tmp < (arr[start]+arr[end])) {
                    end--;
                }
            }
        }
        long result = 0L;
        for(String str : list) {
            String[] words = str.split(",");
            long tmp = 0L;
            /* CX^3 || CX^2 || CX^1 */
            if(words[0].equals(words[1]) && words[1].equals(words[2])) {
                tmp = Long.valueOf(map.get(words[0]));
                int len = map.get(words[0])-3 == 0 ? 1 : map.get(words[0])-3;
                for(int i = map.get(words[0])-1;i>len;i--) {
                    tmp *= i; 
                }
                tmp /= 6;
            } else if(words[0].equals(words[1])) {
                tmp = Long.valueOf(map.get(words[0]));
                int len = map.get(words[0])-2 == 0 ? 1 : map.get(words[0])-2;
                for(int i = map.get(words[0])-1;i>len;i--) {
                    tmp *= i; 
                }
                tmp /= 2;
                tmp *= Long.valueOf(map.get(words[2]));
            } else if(words[1].equals(words[2])) {
                tmp = Long.valueOf(map.get(words[1]));
                int len = map.get(words[1])-2 == 0 ? 1 : map.get(words[1])-2;
                for(int i = map.get(words[1])-1;i>len;i--) {
                    tmp *= i; 
                }
                tmp /= 2;
                tmp *= Long.valueOf(map.get(words[0]));
            } else {
                tmp = Long.valueOf(map.get(words[0])) * Long.valueOf(map.get(words[1])) * Long.valueOf(map.get(words[2]));
            }
            result += tmp;
            result %= 1000000007;
        }
        return (int)result;
    }
}