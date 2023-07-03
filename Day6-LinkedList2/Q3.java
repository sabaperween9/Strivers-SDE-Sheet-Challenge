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

//  ============================ Recursive Approach ====================================================================================
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        return helper(head , k);

    }

    ListNode helper(ListNode head , int k) {
        int len = lengthOfLL(head);
        if(head == null || head.next == null || len < k)
            return head;
        ListNode prev = null , curr = head;
        int kk = k;
        while(curr != null && kk != 0) {
            kk--;
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode temp = prev;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = helper(curr ,k);
        return prev;
    }

    int lengthOfLL(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

// ========================== Approach - 2 (iterative) TC = O(len of LL)=====================================================

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
        if(head == null || head.next == null)
            return head;
        int len = lengthOfLinkedList(head);
        ListNode dummy = new ListNode(-1 , null);
        dummy.next = head;
        ListNode prev = dummy , curr = dummy , next = dummy;
        while(len >= k) {
            curr = prev.next;
            next = curr.next;
            for(int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len -= k;
        }

        return dummy.next;
    }

    int lengthOfLinkedList(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

