class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int n = people.length, p = 0, q = n - 1, cnt = 0;
        while (p <= q) {
            if (people[p] + people[q] <= limit) {
                cnt++;
                p++;
                q--;
            }
            else {
                cnt++;
                q--;
            }
        }
        
        return cnt;
    }
}