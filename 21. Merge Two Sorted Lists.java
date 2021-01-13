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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /* 以 l1 作為主要變動 link，判斷 l2 是否大於小於等於 l1 節點 */
        ListNode head = l1;
        if(l1 != null) {
            /* 需紀錄 l1 前一個節點，因需要將 l2 插入到前 l1 節點與當前 l1 節點中間 */
            ListNode prel1 = null;
            ListNode curl1 = l1;
            ListNode curl2 = l2;
            while(curl2 != null) {
                /* 當 l1 當前節點與 l2 節點大於相等時，將 l2 該節點插入到 l1 節點前，
                 * 將前一個節點指向 l2 新插入之節點(需注意是否有前一個節點，若無代表為開頭就插入了，需紀錄 head)，
                 * 並繼續判斷下一個 l2 節點。
                 *
                 * 當 l1 當前節點與 l2 節點小於時，則需要移動前一個 l1 節點與當前 l1 節點至各自的下一個節點。
                 */
                if(curl1.val >= curl2.val) {
                    ListNode tmp = curl2.next;
                    if(prel1 != null) {
                        prel1.next = curl2;
                        prel1 = curl2;
                    } else {
                        prel1 = curl2;
                        head = curl2;
                    }
                    curl2.next = curl1;
                    curl2 = tmp;
                } else if(curl1.val < curl2.val) {
                    /* 避免 l2 大於所有 l1 的數，會導致 l1 退至 null */
                    if(curl1.next != null) {
                        prel1 = curl1;
                        curl1 = curl1.next;
                    } else {
                        curl1.next = curl2;
                        break;
                    }
                }
            }
        } else {
            return l2;
        }
        return head;
    }
}