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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* 紀錄兩邊長度 */
        int l1_len = 0;
        int l2_len = 0;
        ListNode l1_tmp = l1;
        ListNode l2_tmp = l2;
        while(l1_tmp != null) {
            l1_len++;
            l1_tmp = l1_tmp.next;
        }
        while(l2_tmp != null) {
            l2_len++;
            l2_tmp = l2_tmp.next;
        }
        
        if(l1_len >= l2_len) {
            combineList(l1, l2);
            return l1;
        } else {
            combineList(l2, l1);
            return l2;
        }
    }
    
    /* 依長度較長的一邊作為紀錄總和，之後回傳該 list */
    public void combineList(ListNode longlist, ListNode shortList) {
        
        /* 紀錄前一個點 */
        ListNode preNode = null;
        
        int overflow = 0;
        while(shortList != null) {
            int sum = overflow + longlist.val + shortList.val;
            if(sum/10 != 0) {
                overflow = 1;
                sum = sum % 10;
                preNode = longlist;
            } else {
                overflow = 0;
            }
            longlist.val = sum;
            longlist = longlist.next;
            shortList = shortList.next;
        }
        while(overflow == 1) {
            if(longlist != null) {
                int sum = overflow + longlist.val;
                if(sum/10 != 0) {
                    overflow = 1;
                    sum = sum % 10;
                } else {
                    overflow = 0;
                }
                longlist.val = sum;
                preNode = longlist;
                longlist = longlist.next;
            } else {
                /* 已經超出 list，故新建 node，並加入到 list，
                 * 不會有溢出情況產生，故跳出迴圈
                 */
                preNode.next = new ListNode(overflow);
                break;
            }
        }
    }
}