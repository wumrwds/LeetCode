class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        
        while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            if (num % 2 == 0) {
                num /= 2;
            }
            
            if (num % 3 == 0) {
                num /= 3;
            }
            
            if (num % 5 == 0) {
                num /= 5;
            }
        }
        
        if (num == 1) {
            return true;
        }
        
        return false;
    }
}

/**
   A better way is to do like this:

    public boolean isUgly(int num) {
        if(num==1) return true;
        if(num==0) return false;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }

 */