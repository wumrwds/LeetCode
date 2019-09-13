public class TwoSum {
    private List<Integer> nums = new ArrayList<>();
    private Map<Integer, Integer> hash = new HashMap<>();
    
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        if (!hash.containsKey(number)) {
            nums.add(number);
        }
        
        hash.put(number, hash.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            if (cur == value - cur) {
                if (hash.get(cur) >= 2) {
                    return true;
                }
            }
            else if (hash.containsKey(value - cur)) {
                return true;
            }
        }
        
        return false;
    }
}