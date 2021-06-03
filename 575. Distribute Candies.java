class Solution {
    public int distributeCandies(int[] candyType) {
        /* 取糖果種類數量與能吃的糖果數量中的最小數 */
        HashSet<Integer> set = new HashSet<>();
        for(int candy : candyType) {
            set.add(candy);
        }
        return Math.min(candyType.length/2, set.size());
    }
}