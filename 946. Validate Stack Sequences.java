class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /* 透過 stack 以 pushed 作為基底(一定會滿足 pushed 前提下是否能滿足 popped)
         * ，當推入值後，確認 popped 是否與 stack 值相同，若相同則持續 pop
         * ，直到 stack 為空或是 popped 不相同為止
         * 最後若無法滿足 popped 的話，則長度會不相同
         */
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0;i<pushed.length;i++) {
            stack.push(pushed[i]);
            while(stack.size() != 0 && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return popped.length == popIndex;
    }
}