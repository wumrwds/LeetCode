class Solution {
    /*
    O(MlogM)        M is the number of different cards in the hand
    */
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int card : hand) {
            cnt.put(card, cnt.getOrDefault(card, 0) + 1);
        }
        
        int opened = 0, prev = -1;
        Deque<Integer> deque = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            // if there's a breakpoint or there's some elements missing for remaining a opened groups of size W
            if ((opened > 0 && entry.getKey() > prev + 1) || entry.getValue() < opened) {
                return false;
            }
            
            prev = entry.getKey();                          // record prev
            deque.offerLast(entry.getValue() - opened);     // new increment
            opened += (entry.getValue() - opened);          // update opened
            if (deque.size() == W) {                        // the first in element should be out
                opened -= deque.pollFirst();
            }
        }
        
        return opened == 0;
    }





    /*
    O(Mlog(M) + W*M)
    */
    public boolean isNStraightHand2(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet())
            if (c.get(it) > 0)
                for (int i = W - 1; i >= 0; --i) {      
                    // check the later W-1 element, check whether they are greater or equal to the current; if not, that means its impossible
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    
                    // update by minus the current count
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        return true;
    }
}