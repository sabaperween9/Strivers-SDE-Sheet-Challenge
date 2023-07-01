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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = lengthOfLinkedList(head);
        if(len == n)
            return head.next;
        int eleNo = len - n + 1;
        ListNode prev = head;
        ListNode curr = head;
        while(eleNo - 1 != 0) {
            --eleNo;
            prev = curr;
            curr = curr.next;

        }
        prev.next = curr.next;
        return head;
    }

    int lengthOfLinkedList(ListNode head) {
        int temp = 0;
        while(head != null) {
            temp++;
            head = head.next;
        }
        return temp;
    }
}