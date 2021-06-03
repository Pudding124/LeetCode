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
    public ListNode partition(ListNode head, int x) {
        /* 透過記錄交換位置的前後節點，將小的往前排，大的往後排
         * 當遇到當前節點比 x 大，紀錄該節點與前一個節點，直到
         * 遇到小於 x 的節點，將其位置交換即可
         */
        if(head == null) return head;
        ListNode result = head;
        ListNode tmp = null;
        ListNode tmpPreNode = null;
        ListNode tmpNextNode = null;
        boolean flag = true;
        while(head != null) {
            if(head.val >= x && flag) {
                tmpPreNode = tmp;
                tmpNextNode = head;
                flag = false;
            } else if(head.val < x) {
                if(tmpPreNode != null || tmpNextNode != null) {
                    flag = true;
                    ListNode nowNode = head;
                    ListNode nextNode = head.next;
                    /* 避免是起點 */
                    if(tmpPreNode == null) {
                        result = nowNode;
                        nowNode.next = tmpNextNode;
                        tmp.next = nextNode;
                    } else {
                        tmpPreNode.next = nowNode;
                        nowNode.next = tmpNextNode;
                        tmp.next = nextNode;
                    }
                }
            }
            tmp = head;
            head = head.next;
        }
        return result;
    }
}