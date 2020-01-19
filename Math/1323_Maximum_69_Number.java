class Solution {
    public int maximum69Number (int num) {
        for (int i = 1000, cur = num; i >= 1; i /= 10) {
            int digit = cur / i;
            if (digit == 6) {
                return num + 3*i;
            }
            
            cur = cur % i;
        }
        
        return num;
    }

    public int maximum69Number2 (int num) {
        String numStr = "" + num;
        char[] digits = numStr.toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(digits));
    }
}