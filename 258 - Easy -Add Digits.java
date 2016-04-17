public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}


//old-version
public class Solution {
    public int addDigits(int num) {
        int sum;
        do
        {
            sum = 0;
            while(num > 0)
            {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }while(sum > 9);
        return sum;
    }
}
