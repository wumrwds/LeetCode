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
|              |                     |            |                                                              |

<br/>

## Linked List

| #    | Title | Difficulty | Comment |
| ---- | ----- | ---------- | ------- |
|      |       |            |         |
|      |       |            |         |
|      |       |            |         |

<br/>

## Array

| #    | Title | Difficulty | Comment |
| ---- | ----- | ---------- | ------- |
|      |       |            |         |
|      |       |            |         |
|      |       |            |         |

<br/>

## Two Pointers

| #    | Title | Difficulty | Comment |
| ---- | ----- | ---------- | ------- |
|      |       |            |         |
|      |       |            |         |
|      |       |            |         |

<br/>

## Dynamic Programming

| #            | Title          | Difficulty | Comment                                                      |
| ------------ | -------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 312 | Burst Balloons | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
|              |                |            |                                                              |
|              |                |            |                                                              |

<br/>