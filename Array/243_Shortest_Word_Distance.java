class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length, prev1 = -n, prev2 = -n, minDiff = n;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                minDiff = Math.min(minDiff, i-prev2);
                prev1 = i;
            }
            else if (words[i].equals(word2)) {
                minDiff = Math.min(minDiff, i-prev1);
                prev2 = i;
            }
        }
        
        return minDiff;
    }
}