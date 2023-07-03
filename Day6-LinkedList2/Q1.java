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
// ============================= TC = O(l1 + l2) ==============================================================
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int l1 = lenghtOfLinkedList(headA);
       int l2 = lenghtOfLinkedList(headB);
        int diff = Math.abs(l1 - l2);
        ListNode longList = l1 > l2 ? headA : headB;
        ListNode shortList = longList == headA ? headB : headA;

        while(diff != 0) {
            --diff;
            longList = longList.next;
        }

        while( longList != null && shortList != null) {
            if(longList == shortList)
                return longList;
            longList = longList.next;
            shortList = shortList.next;
        }

        return null;

    }

    int lenghtOfLinkedList(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}