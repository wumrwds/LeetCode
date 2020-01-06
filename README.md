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

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 104  | Minimum Depth of Binary Tree                                 | Easy       |                                                              |
| LeetCode 257  | Binary Tree Paths                                            | Easy       |                                                              |
| LeetCode 110  | Balanced Binary Tree                                         | Easy       | Use custom class ResultType to return more than one value    |
| LeetCode 236  | Lowest Common Ancestor of a Binary Tree                      | Medium     | Two cases: one side each or both in a side; preorder traversal |
| LeetCode 543  | Diameter of Binary Tree                                      | Easy       | Helper function used to calculate the tree depth; in the process of calculating tree depth, update max diameter |
| LeetCode 617  | Merge Two Binary Trees                                       | Easy       | Manipulate two trees at the same time using preorder traversal in a single method |
| LeetCode 958  | [Check Completeness of a Binary Tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree) | Medium     | BFS or Divide & Conquer; BFS: while meeting a null element, break while loop, and check whether there's any non-null nodes remaining in the queue. (after break, we need to iterate the remained elements in the queue) |
| LeetCode 572  | Subtree of Another Tree                                      | Easy       | Two method: One is used to recursively apply on its two subtree; the other is used to recursively check whether two binary tree are the same. |
| LeetCode  103 | Binary Tree Zigzag Level Order Traversal                     | Medium     | Make some modification on level traversal. Use a boolean variable as a switch to control whether in this level we traverse from the left to the right or from the right to the left. Instead of polling the first element in the queue, we poll the last. Be careful about the order with the switch variable. |
| LeetCode 545  | Boundary of Binary Tree                                      | Medium     | Write 3 traversal functions to traverse 3 parts of the binary tree: left side, bottom leaves, right side. **A corner case is [1].** In this case, we need to judge whether this tree is only of level 1, otherwise it will add the root twice into the result set. |

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
| LeetCode 199  | Binary Tree Right Side View           | Medium     | Level traversal on a binary tree. In each level, use a variable to store the size of the current level. |
| LeetCode 994  | Rotting Oranges                       | Easy       | Level traversal on a chess board. First you should add all neighbors of rotten oranges into the BFS queue. Then use a counter to record the total number of fresh oranges. |

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

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 39   | Combination Sum                                              | Medium     |                                                              |
| LeetCode 40   | Combination Sum II                                           | Medium     | Don't allow more than one same elements to be added into combination in a single for loop while writing the DFS helper function. |
| LeetCode 216  | Combination Sum III                                          | Medium     | Brute force approach is okay. Time complexity is O(C(9, k)) => O(9^k). Iterating from bigger end can quit the for loop early and avoid unnecessary work. |
| LeetCode 494  | Target Sum                                                   | Medium     | Also see DP #3                                               |
| LeetCode 301  | Remove Invalid Parentheses                                   | Hard       | First, count the amount of parentheses required for deletion; Then, dfs; use `int idx, int dropOpenCnt, int dropCloseCnt` as parameters; use this condition `if (dropOpenCnt == 0 && dropCloseCnt == 0 && isValid(s)) ` to add element;  Note for recursive call idx should be i |
| LeetCode 698  | [Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets) | Medium     | 1⃣️. calculate the sum of the array, and calculate the sum for each subset. If sum % k != 0, it's false; 2⃣️. use dfs to search all possible subset partitions; just like backtracking subset question, we need a `boolean[] isVisited` and `idx` (permutation doesn't need `idx`, because it cares about the order); if`k == 1`, it just can return true, as we promise the `sum % k = 0` |
| LeetCode 1079 | Letter Tile Possibilities                                    | Medium     | Similar to subsets II & permutation. But there's a more tricky solution. Count the occurrence of all the letters. Then each step select one letter. Count the total selection of the specific length. |
| LeetCode 863  | All Nodes Distance K in Binary Tree                          | Medium     | Use a adjacent to store a binary tree as a graph and for each tree node, the parent also represents an edge. So first we need to use DFS to construct the graph. Then use BFS to collect the node whose distance to the target node is K. |
| LeetCode 980  | Unique Paths III                                             | Hard       | First find the start point and count all empty squares. Then use DFS+Backtracking to iterate all possible paths. If all emptys have been visited and the path reaches the end point, increase counter by 1. |
| LeetCode 841  | Keys and Rooms                                               | Medium     | It's a graph problem. Start from 0, check whether we can connect to all vertices using DFS. |

<br/>

## Linked List

| #            | Title                            | Difficulty | Comment                                                      |
| ------------ | -------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 160 | Intersection of Two Linked Lists | Easy       | Let the tail of List A point to the head of List B; if there's a circle, it means have intersection; otherwise, it has no intersection |
| LeetCode 143 | Reorder List                     | Medium     | 1. find the mid<br/>2. reverse the right part<br/>3. merge two lists |
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

| #             | Title                   | Difficulty | Comment                                                      |
| ------------- | ----------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 347  | Top K Frequent Elements | Medium     | 1. Count occurrences of all elements; 2. Use a min heap with k capacity to filter top k frequent elements; Note that the constructor parameter of PriorityQueue is only the **initial capacity** |
| LeetCode 767  | Reorganize String       | Medium     | Select the most frequent letter then alternately place the selected letters. **Notice** that if there're some duplicates in a priority queue, it's not ensured that priority queue is FIFO. We need to manually poll one more element to check. |
| LeetCode 1086 | High Five               | Easy       | Calculate the average score of each student's **top five scores**. Use Map + MinHeap(PriorityQueue) to implement. Note that the given students' IDs may not be continuous (e.g. 1, 2, 4, 8, ...). If the result is required to be sorted by students' IDs, use a TreeMap to maintain the order. |
| LeetCode 692  | Top K Frequent Words    | Medium     | Similar to LC 347. **Note that** when writing the priority queue comparator, we should return `b.getKey().compareTo(a.getKey())` instead of `a.getKey().compareTo(b.getKey())` in the case of `a.getValue() - b.getValue() == 0`. Think about the following 3 strings in the min heap: "abc", "abd", "abz". We should poll them in the order: "abz", "abd", "abc". The lexicographically larger string should be at the bottom of the heap. **Notice that** ArrayList.set() will throw NullPointerException if there's no element in that index. |

<br/>

## Stack

| #             | Title                                    | Difficulty | Comment                                                      |
| ------------- | ---------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 1249 | Minimum Remove to Make Valid Parentheses | Medium     | Use a stack to keep the indices of the characters required to be removed. Then, remove them togeter. |
| LeetCode 155  | Min Stack                                | Easy       | Implement a stack which can return the min value of the current state. The key is to store the min value of each state. We can use a variable to cache the min for each stack node (define a custom class with fields: val, min, next). Then we can use `next` to connect this linked list to store stack. |
| LeetCode 150  | Evaluate Reverse Polish Notation         | Medium     | Judge whether the current element is '+', '-', '*', '/' first. If not, it's an integer. |
| LeetCode 456  | **132 Pattern**                          | Medium     | Every time we read one letter, we need to maintain a structure which stores all min-max Interval pairs before. We will use a stack here to help merge min-max Interval pairs. See more details in the code. It's better to combine the code with examples. It's not a easy question. |

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
| LeetCode 1099 | Two Sum Less Than K                                          | Easy       | Two pointers after sorting. Note that we can use the following way to get the closest maximum value to a target: `maxSum = Math.max(maxSum, sum)`. There's no need to calculate the difference. |

<br/>

## Sliding Window

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 76  | Minimum Window Substring                                     | Hard       | **Sliding window**: 1. Use two pointers: start and end to represent a window; 2. Move end to find a valid window; 3. When a valid window is found, move start to find a smaller window. |
| LeetCode 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       | 1⃣️ Use a Deque to store the index of elements in sliding window; the elements in Deque is descend, so the maximum occurs in the head, minimum occurs in the end; in each round of loop, we only keep the "promising" elements in the Deque. 2⃣️ Use a prefix max array with a boundary on `index % k == 0` |
| LeetCode 438 | Find All Anagrams in a String                                | Medium     | First expand the window to cover a possible answer, then shrink the window. Use a variable `incomplete` to record how many kinds of letters there're still not covered by the current window. When `incomplete == 0`, shrink and check whether the current window length is equal to `q.length()`. If it's equal, add the current `start` into the result set. Then destroy the state of `incomplete == 0` by expanding `end` of the window. |
| LeetCode 713 | Subarray Product Less Than K                                 | Medium     | the number of subarrays that ends at index `end` is just the window size. Therefore, the total number is just the sum of every valid window's size. |

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
| LeetCode 56  | Merge Intervals            | Medium     | Sort the segments by the left end. Then iterate all segments in the sorted array: if the current segment's left end is less than the last merged segment in the result set, then merge these two. |

<br/>

## Greedy

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 406  | Queue Reconstruction by Height                               | Medium     | Descending sort array by height; for people having same height, ascending sort by index; Then, insert the elements of the sorted array; in each iteration, the current element must be the smallest element due to descending sorting, so just call the method `add(p[i], p)` of LinkedList |
| LeetCode 621  | [Task Scheduler](https://leetcode.com/problems/task-scheduler) | Medium     | https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation; https://github.com/tzheng/interviewprep/blob/master/SourceCode/TaskCoolDown.java |
| LeetCode 1167 | Minimum Cost to Connect Sticks                               | Medium     | Use a min heap to store the elements. Each time poll two minimal elements from the heap until there's only 1 element left in the heap. Return the total cost. |

<br/>

## Hash Table

| #             | Title                              | Difficulty | Comment                                                      |
| ------------- | ---------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode  953 | Verifying an Alien Dictionary      | Easy       | We can compare the first difference of two adjacency words in the List. For example, `"applying"` and `"apples"` have a first difference of `y` vs `e`. Then check wheter the character in first word is before that in the second word. Pay attention to this special case: `apple <-> app`. |
| LeetCode 387  | First Unique Character in a String | Easy       | One pass solution: Use a LinkedHashMap to store the unique \<element, index\> pairs and a HashSet to check whether this element has occurred before. |
| LeetCode 49   | Group Anagrams                     | Medium     | Count letters and then generate a key string using the count in the first step. |
| LeetCode  437 | Path Sum III                       | Easy       | PrefixSum on Binary Tree. Use DFS and a HashMap to record the prefix sums. Notice that HashSet may neglect some cases. |

<br/>

## Dynamic Programming

| #              | Title                           | Difficulty | Comment                                                      |
| -------------- | ------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 312   | Burst Balloons                  | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
| LintCode 92    | Backpack                        | Medium     | Classical knapsack problem; denote dp\[i]\[j] as the max weight for the first i items with backpack of j size; So for the i th item, it will have two cases: in or out; dp\[i]\[j] = max(dp\[i-1]\[j], dp\[i-1]\[j-A\[i]] + A\[i]); **space complexity can be O(V)** |
| LeetCode 494   | Target Sum                      | Medium     | DFS or DP; just see as a knapsack problem; test cases should include `[0,0,0,0,1], 1`; map index [-sum, sum] to [0, 2*sum]; when initializing, `++` the dp\[0]\[-num\[i]] instead of assigning 1 |
| LeetCode 279   | Perfect Squares                 | Medium     | problem of `n` can be divided into the subproblem of `n-square[i]`  + 1; Time complexity is O(n*sqrt(n)) |
| LeetCode 120   | Triangle                        | Medium     | Take care that how to represent the index relationship between the last level index and the current level index: `dp[i][j] consists of dp[i-1][j-1] & dp[i-1][j]`. To meet the O(n) space complexity requirement, we can maintain the dp[] in a *bottom-to-top* approach. In the end, return dp[0]. |
| LeetCode 1223  | Dice Roll Simulation            | Medium     | A little bit difficult. Notice that rollMax represents the max consecutive times. See comments. |
| LeetCode  1102 | Path With Maximum Minimum Value | Medium     | Dijkstra's algorithm. Use a max heap to store the fringes. Use a boolean array to restore whether a point is visited. Once a point is in tree, it will not be modified again. Then just return. |
| LeetCode 264   | Ugly Number                     | Medium     | Use 3 variables to store the current product for facter `2, 3, 5` respectively. |
| LeetCode 62    | Unique Paths                    | Medium     | `dp[i][j] = dp[i-1][j] + dp[i][j-1]`                         |
| LeetCode  63   | Unique Paths II                 | Medium     | The trasition equation is still `dp[i][j] = dp[i-1][j] + dp[i][j-1]`. The only difference is how to treat the obstacles. |

<br/>

## Trie

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 208  | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree) | Medium     | TrieNode(links[R], R = 26, isEnd).                           |
| LeetCode  642 | [Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system) | Hard       | Record the words and its times in each node. Then use a max heap to return top 3. |
|               |                                                              |            |                                                              |

<br/>

## Math

| #             | Title                     | Difficulty | Comment                                                      |
| ------------- | ------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 263  | Ugly Number               | Easy       | Decomposing prime factor by 2, 3, 5                          |
| LeetCode 445  | Add Two Numbers II        | Medium     | Add two numbers which are stored in two linked list. Use two stacks to solve it. Don't forget to check carry after while loop. |
| LeetCode 957  | Prison Cells After N Days | Medium     | Similar to `Game of Life`. But there must be a cycle in this question, since we only have 2^8 possible states. So if N is larger than 2^8, definitely it must have two same states and then it will lead to a cycle. Therefore, our problem now is becoming a question of finding a cycle. We can use a HashSet\<String\> to store the current states we have. The key is generated by `Arrays.toString()`. Note that we don't need to add the initial state into the hashSet, since we don't know whether the initial state is a part of the cycle. We can prove that not adding the initial state can calculate the cycle properly. (See comments) |
| LeetCode 204  | Count Primes              | Easy       | The Sieve of Eratosthenes Algorithm. The core of this algorithm is to mark the numbers as non-primes starting from i\*i. See [Sieve of Eratosthenes Algorithm](https://leetcode.com/static/images/solutions/Sieve_of_Eratosthenes_animation.gif). Starting from 2 until sqrt(n), for each number, if it is prime, mark the number starting from \*i to n as non-primes, in each step of the iterations, increase i by i. Finally, counting all the primes from 2. |
| LeetCode  866 | Prime Palindrome          | Medium     | All even palindrome numbers are non-primes. See [All Even Length Palindrome are Divisible by 11](https://leetcode.com/problems/prime-palindrome/discuss/146798/JavaC%2B%2BPython-All-Even-Length-Palindrome-are-Divisible-by-11). Checking whether a number is prime takes O(sqrt(n)) time, while checking whether a number is palindrome takes O(log(n)) time. So we first form a palindrome greater than N, then check if it is a prime. We can form a odd palindrome number by forming a halve and reversing it (remove the first digit since we need a odd palindrome), then concatenating the two part. Finally, judge whether the gernated number is greater than N and whether it is a prime. |
| LeetCode  168 | Excel Sheet Column Title  | Easy       | Similar to getting each digit in a decimal.                  |

<br/>

