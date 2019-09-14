public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            // prevent from generating duplicates
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            
            // call twoSum() for the right partition
            twoSum(numbers, i + 1, numbers.length - 1, -numbers[i], result);
        }
        
        return result;
    }
    
    public void twoSum(int[] nums, int start, int end, int target, List<List<Integer>> result) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> triplet = new ArrayList<>(3);
                triplet.add(-target);
                triplet.add(nums[start]);
                triplet.add(nums[end]);
                result.add(triplet);
                
                start++;
                while (start < end && nums[start] == nums[start-1]) {
                    start++;
                }
                
                end--;
                while (start < end && nums[end] == nums[end+1]) {
                    end--;
                }
            }
            else if (nums[start] + nums[end] < target) {
                start++;
                while (start < end && nums[start] == nums[start-1]) {
                    start++;
                }
            }
            else if (nums[start] + nums[end] > target) {
                end--;
                while (start < end && nums[end] == nums[end+1]) {
                    end--;
                }
            }
        }
    }
}