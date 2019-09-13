/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Test cases:
 *  [1,1,1]
 *  [1,1,1,2,2,2,3,3,3,4,4,5]
 *  [1]
 *  []
 *  [1,2,3,4,5,6]
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = head, q = head;
        while (q != null) {
            if (p.val != q.val) {
                p.next = q;
                p = p.next;
            }
            
            q = q.next;
        }
        
        // cut the tail
        p.next = null;
        
        return dummy.next;
    }
}