class Solution {
    /*
    sum up all even counts and the (odd-1) counts. If there's any odd counts, increase the final result by 1.
    */
    public int longestPalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        
        int sum = 0;
        boolean oddOccur = false;
        for (Integer cnt : cntMap.values()) {
            if (cnt % 2 == 0) {
                sum += cnt;
            }
            else {
                oddOccur = true;
                sum += (cnt-1);
            }
        }
        
        return sum + (oddOccur ? 1 : 0);
    }


    public int longestPalindrome1(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }
}