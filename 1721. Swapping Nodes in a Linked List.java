/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        /* 收集所有節點，根據指定的位置 k 互相調換節點後，
         * 再依序將所有節點依序重新銜接起來
         */
        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode tmp = list.get(k-1);
        list.set(k-1, list.get(list.size()-k));
        list.set(list.size()-k, tmp);
        
        for(int i = 0;i<list.size();i++) {
            if(i+1 == list.size()) {
                list.get(i).next = null;
            } else {
                list.get(i).next = list.get(i+1);
            }
        }
        return list.get(0);
    }
}