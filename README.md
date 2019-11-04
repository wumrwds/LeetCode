# LeetCode Solution Set

-------------------------------------

A personal LeetCode/LintCode Java solution set.

## Binary Search

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 33  | Search in Rotated Sorted Array                               | Medium     |                                                              |
| LeetCode 81  | Search in Rotated Sorted Array II                            | Medium     |                                                              |
| LeetCode 240 | Search a 2D Matrix II                                        | Medium     | See the L-shaped array as a sorted array; iterate from the left bottom conner, each loop drop a half |
| LeetCode 302 | Smallest Rectangle Enclosing Black Pixels                    | Hard       | Do binary search in all directions                           |
| LeetCode 162 | Find Peak Element                                            | Medium     |                                                              |
| LeetCode 153 | Find Minimum in Rotated Sorted Array                         | Medium     |                                                              |
| LeetCode 154 | Find Minimum in Rotated Sorted Array II                      | Hard       |                                                              |
| LeetCode 34  | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array) | Medium     | Use two BinarySearch to find first and last indices.         |
| LeetCode 162 | [Find Peak Element](https://leetcode.com/problems/find-peak-element) | Medium     | Use binary search to drop a half elements in each iteration. Note that the premise that this question can use binary search is based on two conditions: one is `nums[-1] = nums[n] = -∞`, another is that we only need to return one peak index. |

<br/>

## Binary Tree

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 104 | Minimum Depth of Binary Tree                                 | Easy       |                                                              |
| LeetCode 257 | Binary Tree Paths                                            | Easy       |                                                              |
| LeetCode 110 | Balanced Binary Tree                                         | Easy       | Use custom class ResultType to return more than one value    |
| LeetCode 236 | Lowest Common Ancestor of a Binary Tree                      | Medium     | Two cases: one side each or both in a side; preorder traversal |
| LeetCode 543 | Diameter of Binary Tree                                      | Easy       | Helper function used to calculate the tree depth; in the process of calculating tree depth, update max diameter |
| LeetCode 617 | Merge Two Binary Trees                                       | Easy       | Manipulate two trees at the same time using preorder traversal in a single method |
| LeetCode 958 | [Check Completeness of a Binary Tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree) | Medium     | BFS or Divide & Conquer; BFS: while meeting a null element, break while loop, and check whether there's any non-null nodes remaining in the queue. (after break, we need to iterate the remained elements in the queue) |

<br/>

## Divide & Conquer

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 106 | Construct Binary Tree from Inorder and Postorder Traversal   | Medium     | The last node of preorder array is the current root. Then find its position in inorder array and split each array into two subtree part (both required a start and end boundary). Do it using divide&conquer recursively. |
| LeetCode 124 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum) | Hard       | Declare a global variable to restore the max sum; For any maximum path, its must be composed by two parts: the path from two end nodes to their lowest common ancestor; So the return value of our help Divide & Conquer function is the max sum from the end node to its lca; There's a trick here: `for any part of two subtree, if its max path is nagetive, make it 0`, as negative value will make no contribution to the answer and making it 0 can exclude its influence on the result. |
|              |                                                              |            |                                                              |

<br/>

## BFS

| #             | Title                                 | Difficulty | Comment                                                      |
| ------------- | ------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 297  | Serialize and Deserialize Binary Tree | Hard       | serialize: BFS, then trim null elements in the tail; deserialize: iterate array and add current node to its position; use a queue to record current node which is being added; use a flag to mark left or right, each time meeting a left node means that it requires to get next node to be added |
| LeetCode  133 | Clone Graph                           | Medium     | 3 steps: collect all old nodes in a list; create new nodes and keep it in a pair with old nodes in a map; copy edges |
|               |                                       |            |                                                              |

<br/>

## Connected Components/ Union-Find

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 323  | Number of Connected Components in an Undirected Graph        | Medium     | BFS or DFS; use a boolean[] to record the isVisited state of each node |
| LeetCode 200  | Number of Islands                                            | Medium     | Count connected blocks. Use direction array and bfs to traverse all nodes in the chessboard. Required a private custom class `Point` for queue and a boolean array for marking whether a point has been visited. |
| LeetCode 1202 | [Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps) | Medium     | Use Disjoint Set Algorithm (CLRS Chapter # 21) to get connected components. Then sort each group and generate the new string. |

<br/>

## Topological Sorting

| #            | Title              | Difficulty | Comment                                                      |
| ------------ | ------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 207 | Course Schedule    | Medium     | Build graph and then topological sort                        |
| LeetCode 210 | Course Schedule II | Medium     | Refer to 207. This question requires to return a possible solution. |
| LeetCode 269 | Alien Dictionary   | Hard       | Extend to **210 Course Schedule II**. The question changes the way it gives the graph. We need to determine the `from -> to` pair by comparing words[i] and words[i+1]; For the first time we find a character in these two strings has a different letter in the same index, it's just the `from -> to` pair. Then build graph and do topological sorting. |

<br/>

## DFS

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 39  | Combination Sum                                              | Medium     |                                                              |
| LeetCode 40  | Combination Sum II                                           | Medium     | Don't allow more than one same elements to be added into combination in a single for loop while writing the DFS helper function. |
| LeetCode 216 | Combination Sum III                                          | Medium     | Brute force approach is okay. Time complexity is O(C(9, k)) => O(9^k). Iterating from bigger end can quit the for loop early and avoid unnecessary work. |
| LeetCode 494 | Target Sum                                                   | Medium     | Also see DP #3                                               |
| LeetCode 301 | Remove Invalid Parentheses                                   | Hard       | First, count the amount of parentheses required for deletion; Then, dfs; use `int idx, int dropOpenCnt, int dropCloseCnt` as parameters; use this condition `if (dropOpenCnt == 0 && dropCloseCnt == 0 && isValid(s)) ` to add element;  Note for recursive call idx should be i |
| LeetCode 698 | [Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets) | Medium     | 1⃣️. calculate the sum of the array, and calculate the sum for each subset. If sum % k != 0, it's false; 2⃣️. use dfs to search all possible subset partitions; just like backtracking subset question, we need a `boolean[] isVisited` and `idx` (permutation doesn't need `idx`, because it cares about the order); if`k == 1`, it just can return true, as we promise the `sum % k = 0` |

<br/>

## Linked List

| #            | Title                            | Difficulty | Comment                                                      |
| ------------ | -------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 160 | Intersection of Two Linked Lists | Easy       | Let the tail of List A point to the head of List B; if there's a circle, it means have intersection; otherwise, it has no intersection |
|              |                                  |            |                                                              |
|              |                                  |            |                                                              |

<br/>

## Array

| #            | Title                        | Difficulty | Comment                                                      |
| ------------ | ---------------------------- | ---------- | ------------------------------------------------------------ |
| LintCode 139 | Subarray Sum Closest         | Medium     | subarray_sum(i, j) = prefix[j+1] - prefix[i]; find the least difference of two elements in the prefix array |
| LeetCode 42  | Trapping Rain Water          | Hard       | For each element of the array, the water it contains is equal to $min(LeftMaxBar, RightMaxBar) - height(i))$; to speed up the process of finding leftMax & rightMax, we can store the result in the initialization stage by iterating the array from two ends twice. |
| LeetCode 238 | Product of Array Except Self | Medium     | Use a prefixProduct array and a suffixProduct array (rather than product\[i][j], product\[i][j] would take $O(n^2)$ time); Followup: To limit space complexity to $O(1)$; Just modify the rightProduct to a single variable (the space of answer array is not included as extra space) |

<br/>

## String

| #             | Title                         | Difficulty | Comment |
| ------------- | ----------------------------- | ---------- | ------- |
| LeetCode  157 | Read N Characters Given Read4 | Easy       |         |
|               |                               |            |         |
|               |                               |            |         |

<br/>

## Heap

| #            | Title                   | Difficulty | Comment                                                      |
| ------------ | ----------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 347 | Top K Frequent Elements | Medium     | 1. Count occurrences of all elements; 2. Use a min heap with k capacity to filter top k frequent elements; Note that the constructor parameter of PriorityQueue is only the **initial capacity** |
|              |                         |            |                                                              |
|              |                         |            |                                                              |

<br/>

## Stack

| #             | Title                                    | Difficulty | Comment                                                      |
| ------------- | ---------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 1249 | Minimum Remove to Make Valid Parentheses | Medium     | Use a stack to keep the indices of the characters required to be removed. Then, remove them togeter. |
| LeetCode 155  | Min Stack                                | Easy       | Implement a stack which can return the min value of the current state. The key is to store the min value of each state. We can use a variable to cache the min for each stack node (define a custom class with fields: val, min, next). Then we can use `next` to connect this linked list to store stack. |
| LeetCode 150  | Evaluate Reverse Polish Notation         | Medium     | Judge whether the current element is '+', '-', '*', '/' first. If not, it's an integer. |

<br/>

## Two Pointers

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 83   | Remove Duplicates from Sorted List                           | Easy       | A pointer points to the tail of non-duplicate elements; the other pointer points to the current iteration index; Remeber to cut the tail in the end |
| LintCode 607  | Two Sum - Data structure design                              | Medium     | Use a hashmap to store the <val, cnt> pair and a list to store the distinct internal values; for find(int value) - take care of the case `k + k = value`. In this case, you need to check the count of k |
| LeetCode  15  | 3Sum                                                         | Medium     | a+b = -c, then use twoSum(); Or fix one element, then use two pointers to iterate the other two elements |
| LintCode 31   | Partition Array                                              | Medium     | Similar to the Partition process of Quicksort: Use two pointers; when `left` and `right` both point to an element which don't belong to its partition, swap. |
| LeetCode  215 | Kth Largest Element in an Array                              | Medium     | Use the Partition process of Quicksort to determine the i-th element, then drop a half, search for the Kth element in the left half recursively. |
| LeetCode 560  | Subarray Sum Equals K                                        | Medium     | Use prefixSum array to present the sum of subarray: s[j] - s[i] = k; then the question is converted to `2sum`; Note that nums[i] might be negative |
| LeetCode 76   | Minimum Window Substring                                     | Hard       | **Sliding window**: 1. Use two pointers: start and end to represent a window; 2. Move end to find a valid window; 3. When a valid window is found, move start to find a smaller window. |
| LeetCode 680  | [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii) | Easy       | To skip the useless character, we can't easily skip it by judge `s[p+1] == s[q] or s[p] == s[q-1]`. Instead, we need to check the inner substring using the original validPalindrome function. |
| LeetCode 986  | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections) | Medium     | If the heads of the two sorted list are intersected, output the current intersection ( [maxStart, minEnd]). Then pop the interval with a less end (Because if the following interval will intersect with these two heads, it must intersect with the larger end) |

<br/>

## Sliding Window

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 76  | Minimum Window Substring                                     | Hard       | **Sliding window**: 1. Use two pointers: start and end to represent a window; 2. Move end to find a valid window; 3. When a valid window is found, move start to find a smaller window. |
| LeetCode 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       | Use a Deque to store the index of elements in sliding window; the elements in Deque is descend, so the maximum occurs in the head, minimum occurs in the end; in each round of loop, we only keep the "promising" elements in the Deque |
| LeetCode 438 | Find All Anagrams in a String                                | Medium     | First expand the window to cover a possible answer, then shrink the window. Use a variable `incomplete` to record how many kinds of letters there're still not covered by the current window. When `incomplete == 0`, shrink and check whether the current window length is equal to `q.length()`. If it's equal, add the current `start` into the result set. Then destroy the state of `incomplete == 0` by expanding `end` of the window. |

<br/>

## Bit Manipulation

| #            | Title         | Difficulty | Comment                                                      |
| ------------ | ------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 338 | Counting Bits | Medium     | Divide the number into 2 parts: 1⃣️ the last digit = i % 2; 2⃣️ the other digits = dp[i/2];  i/2 = i >> 1, i%2 = (i & 1) |
|              |               |            |                                                              |
|              |               |            |                                                              |

<br/>

## Sort

| #            | Title                      | Difficulty | Comment                                                      |
| ------------ | -------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 973 | K Closest Points to Origin | Medium     | Use the main idea of PARTITION in Quicksort to **sort the first k-th smallest elements**; it takes O(n) time. |
| LeetCode 252 | Meeting Rooms              | Easy       | Sort by the left/right end of the interval, then compare the right/left end of the intervals. Followup: **LeetCode 253** |
| LeetCode 253 | Meeting Rooms II           | Medium     | Add all left & right end points into an array, then sort by value (Note that we need to make right points before left points while they have same value); After that, iterating the points array; When we meet a left point, it means we are entering a new interval; otherwise, we are leaving an interval. (Just like using a vertical line to sweep from left to right) |

<br/>

## Greedy

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 406 | Queue Reconstruction by Height                               | Medium     | Descending sort array by height; for people having same height, ascending sort by index; Then, insert the elements of the sorted array; in each iteration, the current element must be the smallest element due to descending sorting, so just call the method `add(p[i], p)` of LinkedList |
| LeetCode 621 | [Task Scheduler](https://leetcode.com/problems/task-scheduler) | Medium     | https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation; https://github.com/tzheng/interviewprep/blob/master/SourceCode/TaskCoolDown.java |
|              |                                                              |            |                                                              |

<br/>

## Hash Table

| #             | Title                         | Difficulty | Comment                                                      |
| ------------- | ----------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode  953 | Verifying an Alien Dictionary | Easy       | We can compare the first difference of two adjacency words in the List. For example, `"applying"` and `"apples"` have a first difference of `y` vs `e`. Then check wheter the character in first word is before that in the second word. Pay attention to this special case: `apple <-> app`. |
|               |                               |            |                                                              |
|               |                               |            |                                                              |

<br/>

## Dynamic Programming

| #             | Title                | Difficulty | Comment                                                      |
| ------------- | -------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 312  | Burst Balloons       | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
| LintCode 92   | Backpack             | Medium     | Classical knapsack problem; denote dp\[i]\[j] as the max weight for the first i items with backpack of j size; So for the i th item, it will have two cases: in or out; dp\[i]\[j] = max(dp\[i-1]\[j], dp\[i-1]\[j-A\[i]] + A\[i]); **space complexity can be O(V)** |
| LeetCode 494  | Target Sum           | Medium     | DFS or DP; just see as a knapsack problem; test cases should include `[0,0,0,0,1], 1`; map index [-sum, sum] to [0, 2*sum]; when initializing, `++` the dp\[0]\[-num\[i]] instead of assigning 1 |
| LeetCode 279  | Perfect Squares      | Medium     | problem of `n` can be divided into the subproblem of `n-square[i]`  + 1; Time complexity is O(n*sqrt(n)) |
| LeetCode 120  | Triangle             | Medium     | Take care that how to represent the index relationship between the last level index and the current level index: `dp[i][j] consists of dp[i-1][j-1] & dp[i-1][j]`. To meet the O(n) space complexity requirement, we can maintain the dp[] in a *bottom-to-top* approach. In the end, return dp[0]. |
| LeetCode 1223 | Dice Roll Simulation | Medium     | A little bit difficult. Notice that rollMax represents the max consecutive times. See comments. |

<br/>

## Trie

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 208  | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree) | Medium     | TrieNode(links[R], R = 26, isEnd).                           |
| LeetCode  642 | [Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system) | Hard       | Record the words and its times in each node. Then use a max heap to return top 3. |
|               |                                                              |            |                                                              |

<br/>

