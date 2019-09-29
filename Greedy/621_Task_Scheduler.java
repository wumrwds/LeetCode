package top.wumrwds;


import java.util.*;

/**
 * 621. Task Scheduler
 *
 * - Greedy
 * - First we can take an example of "['A','A','B','B','C','C'], 1" to have a tentative try.
 * - If we go like this "A -> B -> A -> B -> C -> idle -> C", we can easily find it's not the optimal solution
 * - Swap the second A and the first C, we can get "A -> B -> C -> B -> A -> C"
 * - So actually as long as we make enough cooling interval for the maximum occurrence letter, the rest letters
 *   would all meet the requirement.
 * - And we can see the start element and its cooling elements as a group. Each round we select the maximum
 *   occurrence letter in the rest part or idle as the padding elements
 * - As the question doesn't ask us to return a possible task sequence, we don't need to store the task name
 *
 * @author wumrwds
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        // count the occurence times of each letter
        int[] cntMap = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            cntMap[tasks[i] - 'A']++;
        }

        // initialize max heap; Note that Java PriorityQueue is not stable
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (cntMap[i] != 0) {
                maxHeap.offer(cntMap[i]);
            }
        }

        int ans = 0;
        while (!maxHeap.isEmpty()) {
            // since we can't put back the visited elements, we need a temporary container
            List<Integer> tmp = new LinkedList<>();

            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    Integer top = maxHeap.poll();

                    if (top > 1) {
                        tmp.add(top - 1);
                    }

                    ans++;
                }
                else if (tmp.size() == 0) {
                    // all tasks are already scheduled
                    break;
                }
                else {
                    // there's no available different tasks, add an idle
                    ans++;
                }
            }

            // put back all visited elements into the heap in this round
            for (Integer ele : tmp) {
                maxHeap.offer(ele);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','A','A','A'}, 2));
        System.out.println(new Solution().leastInterval(new char[]{'A','B','C','D','E','F'}, 2));
        System.out.println(new Solution().leastInterval(new char[]{'A','B','C','D','E','F'}, 1));
    }
}