class FreqStack {

    /* 將其想成一個階層，第一層是出現第一次的，並皆依順序排
     * 當同一個數字出現第二次後，會在第二層，依此類推，
     * 當需要 pop 時，只需要 pop 最後一個階層的最後一個數字即可
     * ex: 5 7 4
     *     5 7
     *     5
     */
    ArrayList<ArrayList<Integer>> record;
    boolean flag = true;
    
    public FreqStack() {
        record = new ArrayList<ArrayList<Integer>>();
    }
    
    public void push(int x) {
        if(flag) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(x);
            record.add(nums);
            flag = false;
        } else {
            for(int i = 0;i<record.size();i++) {
                if(!record.get(i).contains(x)) {
                    record.get(i).add(x);
                    break;
                }
                if(i == record.size()-1) {
                    ArrayList<Integer> nums = new ArrayList<>();
                    nums.add(x);
                    record.add(nums);
                    break;
                }
            }
        }
    }
    
    public int pop() {
        int result = 0;
        for(int i = record.size()-1;i>=0;i--) {
            if(record.get(i).size() == 1) {
                result = record.get(i).get(0);
                record.remove(i);
                break;
            } else {
                result = record.get(i).get(record.get(i).size()-1);
                record.get(i).remove(record.get(i).size()-1);
                break;
            }
        }
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */