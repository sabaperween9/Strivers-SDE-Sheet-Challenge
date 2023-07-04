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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len = lengthOfLL(head);
         k = k - ( ( k / len ) * len);
         if(k == 0)
            return head;
        int ele = len - k + 1;
        ListNode temp = head;
        ListNode end = head;
        while(temp.next != null) {
            
            if(ele - 2 == 0) {
                end = temp;
            }
            --ele;
            temp = temp.next;
        }
        temp.next = head;
        head = end.next;
        end.next = null;
        return head;
        
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
