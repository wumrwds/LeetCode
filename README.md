# LeetCode Solution Set

-------------------------------------

A personal LeetCode/LintCode Java solution set.

## Binary Search

| #            | Title                                     | Difficulty | Comment                                                      |
| ------------ | ----------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 33  | Search in Rotated Sorted Array            | Medium     |                                                              |
| LeetCode 81  | Search in Rotated Sorted Array II         | Medium     |                                                              |
| LeetCode 240 | Search a 2D Matrix II                     | Medium     | See the L-shaped array as a sorted array; iterate from the left bottom conner, each loop drop a half |
| LeetCode 302 | Smallest Rectangle Enclosing Black Pixels | Hard       | Do binary search in all directions                           |
| LeetCode 162 | Find Peak Element                         | Medium     |                                                              |
| LeetCode 153 | Find Minimum in Rotated Sorted Array      | Medium     |                                                              |
| LeetCode 154 | Find Minimum in Rotated Sorted Array II   | Hard       |                                                              |

<br/>

## Binary Tree

| #            | Title                                   | Difficulty | Comment                                                      |
| ------------ | --------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 104 | Minimum Depth of Binary Tree            | Easy       |                                                              |
| LeetCode 257 | Binary Tree Paths                       | Easy       |                                                              |
| LeetCode 110 | Balanced Binary Tree                    | Easy       | Use custom class ResultType to return more than one value    |
| LeetCode 236 | Lowest Common Ancestor of a Binary Tree | Medium     | Two cases: one side each or both in a side; preorder traversal |
| LeetCode 543 | Diameter of Binary Tree                 | Easy       | Helper function used to calculate the tree depth; in the process of calculating tree depth, update max diameter |
| LeetCode 617 | Merge Two Binary Trees                  | Easy       | Manipulate two trees at the same time using preorder traversal in a single method |

<br/>

## Divide & Conquer

| #            | Title                                                      | Difficulty | Comment                                                      |
| ------------ | ---------------------------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 106 | Construct Binary Tree from Inorder and Postorder Traversal | Medium     | The last node of preorder array is the current root. Then find its position in inorder array and split each array into two subtree part (both required a start and end boundary). Do it using divide&conquer recursively. |
|              |                                                            |            |                                                              |
|              |                                                            |            |                                                              |

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

| #            | Title                      | Difficulty | Comment                                                      |
| ------------ | -------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 39  | Combination Sum            | Medium     |                                                              |
| LeetCode 40  | Combination Sum II         | Medium     | Don't allow more than one same elements to be added into combination in a single for loop while writing the DFS helper function. |
| LeetCode 216 | Combination Sum III        | Medium     | Brute force approach is okay. Time complexity is O(C(9, k)) => O(9^k). Iterating from bigger end can quit the for loop early and avoid unnecessary work. |
| LeetCode 494 | Target Sum                 | Medium     | Also see DP #3                                               |
| LeetCode 301 | Remove Invalid Parentheses | Hard       | First, count the amount of parentheses required for deletion; Then, dfs; use `int idx, int dropOpenCnt, int dropCloseCnt` as parameters; use this condition `if (dropOpenCnt == 0 && dropCloseCnt == 0 && isValid(s)) ` to add element;  Note for recursive call idx should be i |

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

## Two Pointers

| #             | Title                              | Difficulty | Comment                                                      |
| ------------- | ---------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 83   | Remove Duplicates from Sorted List | Easy       | A pointer points to the tail of non-duplicate elements; the other pointer points to the current iteration index; Remeber to cut the tail in the end |
| LintCode 607  | Two Sum - Data structure design    | Medium     | Use a hashmap to store the <val, cnt> pair and a list to store the distinct internal values; for find(int value) - take care of the case `k + k = value`. In this case, you need to check the count of k |
| LeetCode  15  | 3Sum                               | Medium     | a+b = -c, then use twoSum(); Or fix one element, then use two pointers to iterate the other two elements |
| LintCode 31   | Partition Array                    | Medium     | Similar to the Partition process of Quicksort: Use two pointers; when `left` and `right` both point to an element which don't belong to its partition, swap. |
| LeetCode  215 | Kth Largest Element in an Array    | Medium     | Use the Partition process of Quicksort to determine the i-th element, then drop a half, search for the Kth element in the left half recursively. |
| LeetCode 560  | Subarray Sum Equals K              | Medium     | Use prefixSum array to present the sum of subarray: s[j] - s[i] = k; then the question is converted to `2sum`; Note that nums[i] might be negative |
| LeetCode 76   | Minimum Window Substring           | Hard       | **Sliding window**: 1. Use two pointers: start and end to represent a window; 2. Move end to find a valid window; 3. When a valid window is found, move start to find a smaller window. |

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

| #            | Title                          | Difficulty | Comment                                                      |
| ------------ | ------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 406 | Queue Reconstruction by Height | Medium     | Descending sort array by height; for people having same height, ascending sort by index; Then, insert the elements of the sorted array; in each iteration, the current element must be the smallest element due to descending sorting, so just call the method `add(p[i], p)` of LinkedList |
|              |                                |            |                                                              |
|              |                                |            |                                                              |

<br/>

## Hash Table

| #             | Title                         | Difficulty | Comment                                                      |
| ------------- | ----------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode  953 | Verifying an Alien Dictionary | Easy       | We can compare the first difference of two adjacency words in the List. For example, `"applying"` and `"apples"` have a first difference of `y` vs `e`. Then check wheter the character in first word is before that in the second word. Pay attention to this special case: `apple <-> app`. |
|               |                               |            |                                                              |
|               |                               |            |                                                              |

<br/>

## Dynamic Programming

| #            | Title          | Difficulty | Comment                                                      |
| ------------ | -------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 312 | Burst Balloons | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
| LintCode 92  | Backpack       | Medium     | Classical knapsack problem; denote dp\[i]\[j] as the max weight for the first i items with backpack of j size; So for the i th item, it will have two cases: in or out; dp\[i]\[j] = max(dp\[i-1]\[j], dp\[i-1]\[j-A\[i]] + A\[i]); **space complexity can be O(V)** |
| LeetCode 494 | Target Sum     | Medium     | DFS or DP; just see as a knapsack problem; test cases should include `[0,0,0,0,1], 1`; map index [-sum, sum] to [0, 2*sum]; when initializing, `++` the dp\[0]\[-num\[i]] instead of assigning 1 |

<br/>