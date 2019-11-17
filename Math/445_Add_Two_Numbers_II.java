/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // store l1 & l2 in two stacks
        LinkedList<Integer> stack1 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        // add up stack tops
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            int v1, v2;
            if (stack1.isEmpty()) {
                v1 = 0;
            }
            else {
                v1 = stack1.pop();
            }
            
            if (stack2.isEmpty()) {
                v2 = 0;
            }
            else {
                v2 = stack2.pop();
            }
            
            int curVal = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            
            // generate result
            ListNode tmp = dummy.next;
            dummy.next = new ListNode(curVal);
            dummy.next.next = tmp;
        }
        
        if (carry > 0) {
            ListNode tmp = dummy.next;
            dummy.next = new ListNode(carry);
            dummy.next.next = tmp;
        }
        
        return dummy.next;
    }
}