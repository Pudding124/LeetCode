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
    public ListNode reverseKGroup(ListNode head, int k) {
        /* 透過多個指標達成，紀錄結果、第一個節點、前第一個節點、前個節點與下個節點
         * 結果指標需要紀錄第一次交換後，回傳新的結果節點
         * 第一個節點紀錄交換到最後一個點時需導向下一個群組的第一個節點
         * 前第一個節點使用於下一個群組交換完後，第一個節點的導向位置需要變更為交換完後新的第一個節點
         * 前一個節點與後一個節點都是單純用來記錄交換節點的
         * 且需要注意當群組節點不夠，是不會進行交換，故交換前都需要先檢查群組節點是否足夠
         */
        if(k <= 1) return head;
        ListNode result = head;
        ListNode firstNode = null;
        ListNode preFirstNode = head;
        ListNode preNode = null;
        ListNode nextNode = head;
        boolean flag = true;
        int count = k;
        while(nextNode != null) {
            if(count == k) { 
                /* 初始化，並檢查群組節點是否足夠 */
                ListNode scan = nextNode;
                boolean flag2 = false;
                for(int i = 0;i<count;i++) {
                    if(scan != null) {
                        scan = scan.next;
                    } else {
                        flag2 = true;
                        break;
                    }
                }
                if(flag2) {
                    break;
                }
                firstNode = nextNode;
                preNode = nextNode;
                nextNode = nextNode.next;
                count--;
            } else if(count == 1) {
                /* 到達最後一點，交換節點 */
                ListNode tmp = nextNode.next;
                nextNode.next = preNode;
                
                /* 是否為第一次交換，需要變更回傳結果節點位置 */
                if(flag) {
                    result = nextNode;
                    flag = false;
                }
                /* 將上個群組的最後一個點連結到目前這個群組的第一個點 */
                preFirstNode.next = nextNode;
                preFirstNode = firstNode;
                
                /* 避免下個群組不交換，先將目前群組的最後一個點連結到下個群組第一個點 */
                nextNode = tmp;
                firstNode.next = nextNode;
                count = k;
            } else {
                /* 交換節點 */
                ListNode tmp = nextNode.next;
                nextNode.next = preNode;
                preNode = nextNode;
                nextNode = tmp;
                count--;
            }
        }
        return result;
    }
}
