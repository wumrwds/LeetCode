class Solution {
    public boolean validPalindrome(String s) {
        int p = 0, q = s.length() - 1;
        while (p < q) {
            if (s.charAt(p) != s.charAt(q)) {
                // can't simply judge whether s[p+1] == s[q] || s[p] == s[q-1] here
                // eg. abacuuc(u)aba
                return isValid(s, p+1, q) || isValid(s, p, q-1);
            }
                
            p++;
            q--;
        }
        
        return true;
    }
    
    private boolean isValid(String s, int p, int q) {
        while (p < q) {
            if (s.charAt(p) != s.charAt(q)) {
                return false;
            }
                
            p++;
            q--;
        }
        
        return true;
    }
}