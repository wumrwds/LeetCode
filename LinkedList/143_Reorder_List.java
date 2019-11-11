/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    
    1. find the mid
    2. reverse the right part
    3. merge two lists
    
    */
    public void reorderList(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        
        // use two pointers to find the mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the right part
        ListNode mid = slow, cur = slow, prev = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        // merge two lists
        ListNode curLeft = head, curRight = prev, dummy = new ListNode(0);
        cur = dummy;
        while (curLeft != mid && curRight != null) {
            cur.next = curLeft;
            cur = cur.next;
            curLeft = curLeft.next;
            
            cur.next = curRight;
            cur = cur.next;
            curRight = curRight.next;
        }
    }
}