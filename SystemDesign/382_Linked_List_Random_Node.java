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
    Problem:
        Choose k entries from n numbers. Make sure each number is selected with the probability of k/n
    
    Basic idea:
        Choose 1, 2, 3, ..., k first and put them into the reservoir.
        For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
        For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
        Repeat until k+i reaches n

    Proof:
        For k+i, the probability that it is selected and will replace a number in the reservoir is k/(k+i)
        For a number in the reservoir before (let's say X), the probability that it keeps staying in the reservoir is
            P(X was in the reservoir last time) × P(X is not replaced by k+i)
            = P(X was in the reservoir last time) × (1 - P(k+i is selected and replaces X))
            = k/(k+i-1) × （1 - k/(k+i) × 1/k）
            = k/(k+i)
        
        P(X was in the reservoir last time) = k/(k+i-1) because of induction

        When k+i reaches n, the probability of each number staying in the reservoir is k/n


    Example
        Choose 3 numbers from [111, 222, 333, 444]. Make sure each number is selected with a probability of 3/4
        First, choose [111, 222, 333] as the initial reservior
        Then choose 444 with a probability of 3/4
        For 111, it stays with a probability of
            P(444 is not selected) + P(444 is selected but it replaces 222 or 333)
            = 1/4 + 3/4*2/3
            = 3/4
        The same case with 222 and 333
        Now all the numbers have the probability of 3/4 to be picked

    This Problem
        This problem is the sp case where k=1
    */
    
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int i = 1, reservoir = 0;
        ListNode cur = head;
        
        while (cur != null) {
            if (ThreadLocalRandom.current().nextDouble() < 1.0 / i) {
               reservoir = cur.val;
            }
            
            cur = cur.next;
            i++;
        }
        
        return reservoir;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */