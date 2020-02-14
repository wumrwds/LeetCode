class Solution {
    /*
    Using binary search to find the start index of the window.
    We can see that in the final state, the difference of the left start index's element must be
    less than that of the right end index.
    */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int start = 0, end = n - k;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ans.add(arr[start + i]);
        }
        return ans;
    }
}