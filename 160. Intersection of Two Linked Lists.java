/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* 先計算 headA 與 headB 的長度
         * 因相同部分只會在剩餘長度相同時出現，故當 headA 與 headB 長度不同時
         * 不會有相同部分出現，將長度較長的部分持續往後尋找，當兩邊長度相同時
         * 再依序比較是否為相同物件
         */
        int Alen = 0;
        int Blen = 0;
        ListNode Atmp = headA;
        ListNode Btmp = headB;
        while(Atmp != null || Btmp != null) {
            if(Atmp != null) {
                Alen++;
                Atmp = Atmp.next;
            }
            if(Btmp != null) {
                Blen++;
                Btmp = Btmp.next;
            }
        }
        if(Alen >= Blen) {
            while(Alen != 0) {
                if(Alen > Blen) {
                    headA = headA.next;
                    Alen--;
                } else if(Alen == Blen) {
                    if(headA == headB) {
                        return headA;
                    } else {
                        headA = headA.next;
                        headB = headB.next;
                        Alen--;
                        Blen--;
                    }
                }
            }
        } else {
            while(Blen != 0) {
                if(Blen > Alen) {
                    headB = headB.next;
                    Blen--;
                } else if(Blen == Alen) {
                    if(headB == headA) {
                        return headB;
                    } else {
                        headA = headA.next;
                        headB = headB.next;
                        Alen--;
                        Blen--;
                    }
                }
            }
        }
        return null;
    }
}