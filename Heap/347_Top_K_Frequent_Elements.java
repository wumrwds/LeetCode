package top.wumrwds;


import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * 1. Count occurrences of all elements
     * 2. Use a min heap with k capacity to filter top k frequent elements
     *
     * Note that k doesn't restrict the capacity of the min heap (Java PriorityQueue)
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0) {
            return Collections.emptyList();
        }

        // count the occurrences of all elements
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentCnt = cntMap.getOrDefault(nums[i], 0);
            cntMap.put(nums[i], currentCnt + 1);
        }

        // declare min heap with an initial capacity of k; Note that k doesn't restrict the capacity of the min heap
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        // put entries into the min heap
        for (Map.Entry<Integer, Integer> frequency : cntMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(frequency);
            }
            else {
                if (minHeap.peek().getValue() < frequency.getValue()) {
                    minHeap.poll();
                    minHeap.offer(frequency);
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> element : minHeap) {
            result.add(element.getKey());
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {1,1,1,2,2,3};
        int[] b = {1,1,1,1,1,1,2};
        int[] c = {1};
        int[] d = {};
        int[] e = {1,1,1,2,2,3,3,4,3,21,3,12,3,1,23,12,3,12,3,123,123124,34};

        System.out.println(new Solution().topKFrequent(a, 2));
        System.out.println(new Solution().topKFrequent(a, 3));
        System.out.println(new Solution().topKFrequent(a, 1));
        System.out.println(new Solution().topKFrequent(b, 2));
        System.out.println(new Solution().topKFrequent(c, 2));
        System.out.println(new Solution().topKFrequent(d, 2));
        System.out.println(new Solution().topKFrequent(e, 0));
        System.out.println(new Solution().topKFrequent(e, 2));
        System.out.println(new Solution().topKFrequent(e, 4));
        System.out.println(new Solution().topKFrequent(e, 6));
    }
}