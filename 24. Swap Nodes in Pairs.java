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
    public ListNode swapPairs(ListNode head) {
        /* 判斷若少於兩個，則不能交換直接回傳 */
        if(head == null || head.next == null) return head;
        
        ListNode tmp = head;
        ListNode pre = null;
        head = head.next;
        
        /* 紀錄為雙數節點時，需進行交換，否則記錄當前節點(pre)，並繼續往下 */
        boolean flag = false;
        /* 記錄前一組交換過的最後節點(prepre)，因下一個交換後，前一組最後節點的 next 會銜接當前交換後的頭
         * A B C D -> B A C D
         * 此時需紀錄 A，當 C D 交換完後，須將 A 的 next 移至 D 上
         */
        ListNode prepre = null;
        while(tmp != null) {
            if(flag) {
                if(prepre != null) {
                    prepre.next = tmp;
                }
                pre.next = tmp.next;
                tmp.next = pre;
                prepre = pre;
                tmp = pre;
                tmp = tmp.next;
                flag = false;
            } else {
                pre = tmp;
                tmp = tmp.next;
                flag = true;
            }
        }
        
        return head;
    }
}