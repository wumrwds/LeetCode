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
| LeetCode 200  | Number of Islands                     | Medium     | Count connected blocks. Use direction array and bfs to traverse all nodes in the chessboard. Required a private custom class `Point` for queue and a boolean array for marking whether a point has been visited. |

<br/>

## Topological Sorting

| #            | Title              | Difficulty | Comment                                                      |
| ------------ | ------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 207 | Course Schedule    | Medium     | Build graph and then topological sort                        |
| LeetCode 210 | Course Schedule II | Medium     | Refer to 207. This question requires to return a possible solution. |
|              |                    |            |                                                              |

<br/>

## DFS

| #            | Title               | Difficulty | Comment                                                      |
| ------------ | ------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 39  | Combination Sum     | Medium     |                                                              |
| LeetCode 40  | Combination Sum II  | Medium     | Don't allow more than one same elements to be added into combination in a single for loop while writing the DFS helper function. |
| LeetCode 216 | Combination Sum III | Medium     | Brute force approach is okay. Time complexity is O(C(9, k)) => O(9^k). Iterating from bigger end can quit the for loop early and avoid unnecessary work. |
| LeetCode 494 | Target Sum          | Medium     | Also see DP #3                                               |

<br/>

## Linked List

| #            | Title                            | Difficulty | Comment                                                      |
| ------------ | -------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 160 | Intersection of Two Linked Lists | Easy       | Let the tail of List A point to the head of List B; if there's a circle, it means have intersection; otherwise, it has no intersection |
|              |                                  |            |                                                              |
|              |                                  |            |                                                              |

<br/>

## Array

| #            | Title                | Difficulty | Comment                                                      |
| ------------ | -------------------- | ---------- | ------------------------------------------------------------ |
| LintCode 139 | Subarray Sum Closest | Medium     | subarray_sum(i, j) = prefix[j+1] - prefix[i]; find the least difference of two elements in the prefix array |
|              |                      |            |                                                              |
|              |                      |            |                                                              |

<br/>

## Heap

| #            | Title                   | Difficulty | Comment                                                      |
| ------------ | ----------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 347 | Top K Frequent Elements | Medium     | 1. Count occurrences of all elements; 2. Use a min heap with k capacity to filter top k frequent elements; Note that the constructor parameter of PriorityQueue is only the **initial capacity** |
|              |                         |            |                                                              |
|              |                         |            |                                                              |

<br/>

## Two Pointers

| #            | Title                              | Difficulty | Comment                                                      |
| ------------ | ---------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 83  | Remove Duplicates from Sorted List | Easy       | A pointer points to the tail of non-duplicate elements; the other pointer points to the current iteration index; Remeber to cut the tail in the end |
| LintCode 607 | Two Sum - Data structure design    | Medium     | Use a hashmap to store the <val, cnt> pair and a list to store the distinct internal values; for find(int value) - take care of the case `k + k = value`. In this case, you need to check the count of k |
| LeetCode  15 | 3Sum                               | Medium     | a+b = -c, then use twoSum(); Or fix one element, then use two pointers to iterate the other two elements |
| LintCode 31  | Partition Array                    | Medium     | Similar to the Partition process of Quicksort: Use two pointers; when `left` and `right` both point to an element which don't belong to its partition, swap. |

<br/>

## Bit Manipulation

| #            | Title         | Difficulty | Comment                                                      |
| ------------ | ------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 338 | Counting Bits | Medium     | Divide the number into 2 parts: 1⃣️ the last digit = i % 2; 2⃣️ the other digits = dp[i/2];  i/2 = i >> 1, i%2 = (i & 1) |
|              |               |            |                                                              |
|              |               |            |                                                              |

<br/>

## Greedy

| #            | Title                          | Difficulty | Comment                                                      |
| ------------ | ------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 406 | Queue Reconstruction by Height | Medium     | Descending sort array by height; for people having same height, ascending sort by index; Then, insert the elements of the sorted array; in each iteration, the current element must be the smallest element due to descending sorting, so just call the method `add(p[i], p)` of LinkedList |
|              |                                |            |                                                              |
|              |                                |            |                                                              |

<br/>

## Dynamic Programming

| #            | Title          | Difficulty | Comment                                                      |
| ------------ | -------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 312 | Burst Balloons | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
| LintCode 92  | Backpack       | Medium     | Classical knapsack problem; denote dp\[i]\[j] as the max weight for the first i items with backpack of j size; So for the i th item, it will have two cases: in or out; dp\[i]\[j] = max(dp\[i-1]\[j], dp\[i-1]\[j-A\[i]] + A\[i]); **space complexity can be O(V)** |
| LeetCode 494 | Target Sum     | Medium     | DFS or DP; just see as a knapsack problem; test cases should include `[0,0,0,0,1], 1`; map index [-sum, sum] to [0, 2*sum]; when initializing, `++` the dp\[0]\[-num\[i]] instead of assigning 1 |

<br/>