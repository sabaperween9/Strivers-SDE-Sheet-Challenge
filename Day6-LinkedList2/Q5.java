/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//  ====================== TC : O(n) ===============================================================
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head == null || head.next == null)
            return null;
        
         ListNode start = head;
         ListNode slow = head;
         ListNode fast = head;

         while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
             if(fast == slow) {
                 while(start != slow) {
                     start = start.next;
                     slow = slow.next;
                 }

                 return slow;
             }

         }
         return null;

    }
}