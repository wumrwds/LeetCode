class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] digitsOfA = parseComplex(a), digitsOfB = parseComplex(b);
        
        return String.format("%d+%di", digitsOfA[0] * digitsOfB[0] - digitsOfA[1] * digitsOfB[1],
                            digitsOfA[0] * digitsOfB[1] + digitsOfA[1] * digitsOfB[0]);
    }
    
    private int[] parseComplex(String num) {
        int[] ret = new int[2];
        String[] digits = num.split("\\+|i");
        for (int i = 0; i < digits.length; i++) {
            ret[i] = Integer.parseInt(digits[i]);
        }
        
        return ret;
    }
}