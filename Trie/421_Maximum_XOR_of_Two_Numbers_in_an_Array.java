class Solution {
    private class TrieNode {
        private TrieNode[] links = new TrieNode[2];
        
        public boolean contains(char ch) {
            return links[ch - '0'] != null;
        }
    }
    
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // get the largest number
        int maxNum = nums[0], n = nums.length;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        
        // get 1000...000
        int L = Integer.toBinaryString(maxNum).length(), bitMask = 1;
        for (int i = 0; i < L; i++) {
            bitMask <<= 1;
        }
        
        TrieNode trie = new TrieNode();
        int curMaxXOR = 0;
        for (int i = 0; i < n; i++) {
            // remove the first character
            String binaryStr = Integer.toBinaryString(nums[i] | bitMask).substring(1);
            
            TrieNode cur = trie, op = trie;
            int maxXOR = 0;
            for (Character ch : binaryStr.toCharArray()) {
                // insert into trie
                if (!cur.contains(ch)) {
                    cur.links[ch - '0'] = new TrieNode();
                }
                cur = cur.links[ch - '0'];
                
                char opBit = ch == '0' ? '1' : '0';
                if (op.contains(opBit)) {
                    maxXOR = (maxXOR << 1) | 1;
                    op = op.links[opBit - '0'];
                }
                else {
                    maxXOR <<= 1;
                    op = op.links[ch - '0'];
                }
            }
            
            curMaxXOR = Math.max(curMaxXOR, maxXOR);
        }
        
        return curMaxXOR;
    }
}