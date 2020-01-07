class Solution {
    public int compareVersion(String version1, String version2) {
        String[] digits1 = version1.split("\\.");
        String[] digits2 = version2.split("\\.");
        
        int len1 = digits1.length, len2 = digits2.length;
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int digit1 = (i < len1) ? Integer.parseInt(digits1[i]) : 0;
            int digit2 = (i < len2) ? Integer.parseInt(digits2[i]) : 0;
            
            if (digit1 > digit2) {
                return 1;
            }
            else if (digit1 < digit2) {
                return -1;
            }
        }
        
        return 0;
    }
}