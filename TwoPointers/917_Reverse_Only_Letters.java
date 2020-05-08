class Solution {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        
        int n = charArray.length, p = 0, q = n - 1;
        while (p < q) {
            if (Character.isLetter(charArray[p]) && Character.isLetter(charArray[q])) {
                // swap
                char tmp = charArray[p];
                charArray[p] = charArray[q];
                charArray[q] = tmp;
                
                p++;
                q--;
            }
            else if (!Character.isLetter(charArray[p])) {
                p++;
            }
            else if (!Character.isLetter(charArray[q])) {
                q--;
            }
        }
        
        return new String(charArray);
    }
}