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
| LeetCode 658 | Find K Closest Elements                                      | Medium     | **Good question.** Using binary search to find the start index of the k window. A obvious characteristic of the final state is that the difference of left element and x should always be less than or equal to that of the right element. So we can use `x - arr[mid] > arr[mid + k] - x` as the binary search condition and we initialize like `int start = 0, end = n - k;`, since the start index of the k window must be in this range. |

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
| LeetCode 105  | Construct Binary Tree from Preorder and Inorder Traversal    | Medium     | Use the first element in the preorder array to determine the root. Then find the root value in the inorder array and separate the original array into two partitions. We can implement it by using a helper function. See details in the code. Notice to handle the `null` node case. |
| LeetCode 235  | Lowest Common Ancestor of a Binary Search Tree               | Easy       | If the current node's value is between `p` and `q`, return it as the lowest common ancester. **Notice that p.val might be larger than q.val, we need to do a check first.** |
| LeetCode 314  | Binary Tree Vertical Order Traversal                         | Medium     | Cannot use pre/in/postorder traversal to traverse all the nodes, Since the vertical order traversal must be from root to leaves. So we can use BFS to solve this problem. |
| LeetCode 116  | Populating Next Right Pointers in Each Node                  | Medium     | The requirement is to limit the space complexity to O(1), so we cannot use BFS since we need a O(n) space queue. Alternately, we can use two pointers: one points to the head of each level, another points to currently operating node. For each `cur` node, we connect its `cur.left.next` to `cur.right` and then move cur to the next node in the same level by `cur = cur.next`. |
| LeetCode 117  | Populating Next Right Pointers in Each Node II               | Medium     | Extended from 116. The binary tree now is not a perfect tree. We can use **3 pointers** to solve this case: `levelHead` represents the head of the next level, `cur` represents the current node of the current level, `lead` represents the current leading node for assigning `.next` attribute. |
| LeetCode 979  | Distribute Coins in Binary Tree                              | Medium     | Use a helper function to do divide conquer recursion call. The helper function will return how many coins it can provided to the higher level. And use a global variable to record the steps for moving coins. The coins a tree can provide is equal to `root.val + leftRes + rightRes - 1`. The steps for moving coins can be calculated by `res += (abs(leftRes) + abs(rightRes))`. |

<br/>

## Divide & Conquer

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 106  | Construct Binary Tree from Inorder and Postorder Traversal   | Medium     | The last node of preorder array is the current root. Then find its position in inorder array and split each array into two subtree part (both required a start and end boundary). Do it using divide&conquer recursively. |
| LeetCode 124  | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum) | Hard       | Declare a global variable to restore the max sum; For any maximum path, its must be composed by two parts: the path from two end nodes to their lowest common ancestor; So the return value of our help Divide & Conquer function is the max sum from the end node to its lca; There's a trick here: `for any part of two subtree, if its max path is nagetive, make it 0`, as negative value will make no contribution to the answer and making it 0 can exclude its influence on the result. |
| LeetCode 1325 | Delete Leaves With a Given Value                             | Medium     | First, apply the function on both of the two subtrees. Then, handle the current root node based on the results we get in the first step. |

<br/>

## BFS

| #             | Title                                 | Difficulty | Comment                                                      |
| ------------- | ------------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 297  | Serialize and Deserialize Binary Tree | Hard       | serialize: BFS, then trim null elements in the tail; deserialize: iterate array and add current node to its position; use a queue to record current node which is being added; use a flag to mark left or right, each time meeting a left node means that it requires to get next node to be added |
| LeetCode  133 | Clone Graph                           | Medium     | 3 steps: collect all old nodes in a list; create new nodes and keep it in a pair with old nodes in a map; copy edges |
| LeetCode 199  | Binary Tree Right Side View           | Medium     | Level traversal on a binary tree. In each level, use a variable to store the size of the current level. |
| LeetCode 994  | Rotting Oranges                       | Easy       | Level traversal on a chess board. First you should add all neighbors of rotten oranges into the BFS queue. Then use a counter to record the total number of fresh oranges. |
| LeetCode 542  | 01 Matrix                             | Medium     | Use a one-time BFS which starts at all 0 points. For each level, increase the distance by one. Use a matrix to record the shortest distance to 0 for every points. If the current distance is less than `ans[i][j]`, update `ans[i][j]` and add it into the BFS queue. **Do not** use a `boolean[][] isVisited` array and set the non-zero point to `Integer.MAX_VALUE` in the beginning. See more details in the code. |
| LeetCode 909  | Snakes and Ladders                    | Medium     | **We can't use DP** to solve this problem since there're snakes and ladders which will destroy the optimal subproblem structure. Use BFS to do level traversal until reaching the end point. Write a helper function to get the coordinate by the square number `i`. If a snake takes to a previously visited square, skip it so that we will not get into a cycle. |
| LeetCode 286  | Walls and Gates                       | Medium     | Similar to `LeetCode 542`.                                   |
| LeetCode 505  | The Maze II                           | Medium     | Similar to `LeetCode 490`. This problem requires to calculate the distance to the stop points. Thus we can use BFS to do it. |
| LeetCode 1306 | Jump Game III                         | Medium     | Use BFS or DFS to traverse. If find an index whose corresponding element is equal to 0, return true. |

<br/>

## Connected Components & Union-Find

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 323  | Number of Connected Components in an Undirected Graph        | Medium     | BFS or DFS; use a boolean[] to record the isVisited state of each node |
| LeetCode 200  | Number of Islands                                            | Medium     | Count connected blocks. Use direction array and bfs to traverse all nodes in the chessboard. Required a private custom class `Point` for queue and a boolean array for marking whether a point has been visited. |
| LeetCode 1202 | [Smallest String With Swaps](https://leetcode.com/problems/smallest-string-with-swaps) | Medium     | Use Disjoint Set Algorithm (CLRS Chapter # 21) to get connected components. Then sort each group and generate the new string. |
| LeetCode 1061 | Lexicographically Smallest Equivalent String                 | Medium     | Use UnionFind to divide letters into serveral groups. Then get the smallest letter for each group. **Note that** we can also do some slight modification on the original UnionFind, since we only need to get the smallest letter in each group. So we don't need rank array, and we just simply attach the letter with higher lexicographical order to the lower one. (See the second solution in the code.) |

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
| LeetCode 733  | Flood Fill                                                   | Easy       | Flood fill the same color pixels. We can use a helper function to do the DFS easily. **Note that** if the `newColor` is the same color as the target pixel, do nothing and return the original matrix. |
| LeetCode 490  | The Maze                                                     | Medium     | DFS in a fixed direction. Use a helper `dfs` function to do it. Then use a 2D `boolean[][]` array to record the stop points. When the DFS meets a visited stop point, just skip it. |
| LeetCode 694  | Number of Distinct Islands                                   | Medium     | We can use DFS to traverse each connected component. In order to distinguish each different island shape, we can generate a string of traversal order and use a hashset to remove the duplicate. **Notice that ** for the case `[[1,1,0],[0,1,1],[0,0,0],[1,1,1],[0,1,0]]`  if we don't add a delimiter for each node, it will have some duplicates. |
| LeetCode 1087 | Brace Expansion                                              | Medium     | Backtracking. Better to parse curly braces first, then start to do DFS. Also better to do sorting before DFS. |
| LeetCode 417  | Pacific Atlantic Water Flow                                  | Medium     | We can consider in a reverse way: this question requires to find out the grids which can both reach Pacific and Atlantic. So we can start from Pacific and Atlantic, then see which grids can be reached from Pacific and Atlantic respectively. Finally, collect the grids which can be reached both by Pacific and Atlantic. |
| LeetCode 547  | Friend Circles                                               | Medium     | Find SCC in undirected graph. Use DFS to resolve it. (See the code) **Note that** we need to use Tarjan's algorithm to find SCC in directed graph. We can also use UNION-FIND to solve this question. |
| LeetCode 842  | Split Array into Fibonacci Sequence                          | Medium     | Do backtracking. Record the previous two numbers. Some cases are required to be handled: one is starting with`0`, `0` is valid, but `0112`, `0000` are invalid; another is for integers that are of length 10 but still less than `Integer.MAX_VALUE`. The code is ugly, recommend to rewrite in the future. |

<br/>

## Linked List

| #            | Title                            | Difficulty | Comment                                                      |
| ------------ | -------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 160 | Intersection of Two Linked Lists | Easy       | Let the tail of List A point to the head of List B; if there's a circle, it means have intersection; otherwise, it has no intersection |
| LeetCode 143 | Reorder List                     | Medium     | 1. find the mid<br/>2. reverse the right part<br/>3. merge two lists |
| LeetCode 287 | Find the Duplicate Number        | Medium     | It's a problem on array, but it can be converted to a linked list problem similar to `Linked List Cycle II`. Use `slow = nums[slow]; fast = nums[nums[fast]];` to move to the next node in the "linked list". It takes O(n) time. Another idea is to use Binary Search to check the number of elements which are less than and equal to `mid` (not `nums[mid]`) in the whole array is less than and equal to mid. If it's true, do recursively in the right part, otherwise do it in the left part. |

<br/>

## Array

| #             | Title                                  | Difficulty | Comment                                                      |
| ------------- | -------------------------------------- | ---------- | ------------------------------------------------------------ |
| LintCode 139  | Subarray Sum Closest                   | Medium     | subarray_sum(i, j) = prefix[j+1] - prefix[i]; find the least difference of two elements in the prefix array |
| LeetCode 42   | Trapping Rain Water                    | Hard       | For each element of the array, the water it contains is equal to $min(LeftMaxBar, RightMaxBar) - height(i))$; to speed up the process of finding leftMax & rightMax, we can store the result in the initialization stage by iterating the array from two ends twice. |
| LeetCode 238  | Product of Array Except Self           | Medium     | Use a prefixProduct array and a suffixProduct array (rather than product\[i][j], product\[i][j] would take $O(n^2)$ time); Followup: To limit space complexity to $O(1)$; Just modify the rightProduct to a single variable (the space of answer array is not included as extra space) |
| LeetCode 840  | Magic Squares In Grid                  | Easy       | 1. the center must be 5<br/>2. the order must be 43816729 or 92761834<br/>3. the even must be in the corner, the odd must be on the edge (only check one point is enough) |
| LeetCode 531  | Lonely Pixel I                         | Medium     | Use two arrays to record how many `B` occur in this row or col. If it's the first time it occurs, plus 1; if not, decrease by 1. After that, check all grids in the matrix whether there's a `B` in the rowCnt and colCnt equals 1 places (i.e. `rowCnt[i] == 1 && colCnt[j] == 1 && picture[i][j] == 'B'` ) |
| LeetCode 1352 | Product of the Last K Numbers          | Medium     | Prefix Product. If meeting a `0`, clear the prefix product array and start from the beginning `1`. When returning, we should compare the length of the prefix product array, if `length < k`, we should return `0`, since we have a `0` in the `k` elements and the product must be `0`. Another way is to use a List to compress consequent `1` and `0`. Because the product is restricted within the integer range. That means the multiply over `2` can at most occur `32` times, otherwise it will over flow. So the other factors must be `0` and `1`. So we can compress and every time just product the rightmost k. |
| LeetCode 846  | Hand of Straights                      | Medium     | **Ordered Map** question. Use an ordered map to collect the count of each card in the hand. Then iterate the non-zero elements in the map; check the later W-1 element, check whether they are greater or equal to the current; if not, that means its impossible. Then update the count by minus the current count. It takes O(M * log(M) + W*M). M is the number of the unique cards in the hand. See another O(M * log(M)) in the code. |
| LeetCode 243  | Shortest Word Distance                 | Easy       | Record the last occurrence of these two words respectively. Calculate the minimum distance every time when we meet a `word1` or `word2`. |
| LeetCode 1144 | Decrease Elements To Make Array Zigzag | Medium     | Make all the elements in the odd indices less than its two neighbors or make all the elements in the even indices less than its two neighbors. Return the minimum decrement step number. And we can do it in one pass. |

<br/>

## String

| #             | Title                         | Difficulty | Comment                                                      |
| ------------- | ----------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 157  | Read N Characters Given Read4 | Easy       |                                                              |
| LeetCode 165  | Compare Version Numbers       | Medium     | Add 0 in the tail for the shorter version string: `digit1 = (i < len1) ? Integer.parseInt(digits1[i]) : 0`. **Notice that** do not try to trim tailing zero for the longer version string. |
| LeetCode  811 | Subdomain Visit Count         | Easy       | How to get the suffix strings (e.g. `"discuss.leetcode.com", "leetcode.com", "com"`) from a url `"discuss.leetcode.com"` |
| LeetCode 1023 | Camelcase Matching            | Medium     | Just think about this three kinds of test cases`queries = [aFoB, aFaocBad, Fo], pattern = "FoB"`. Write a check function to handle this three kinds of cases using Two Pointers. |
| LeetCode 1002 | Find Common Characters        | Easy       | Do bag intersaction for every letter in the given string set. We can use a integer array `cnt[]` to record the occurance for every letter in each string. Then we choose the minimum cnt of every letter for all strings as the final returned answer. |

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
| LeetCode 388  | Longest Absolute File Path               | Medium     | **`\n, \t, \r` is a single character, not two characters. They are one of the ASCII characters!!!** We can use a variable `level` and a stack to record the current prefix path length. Don't forget there's a slash between two subdirectories. |
| LeetCode 636  | Exclusive Time of Functions              | Medium     | Use a stack to record the current non-finished functions and a variable `prev` to record the last switching timestamp. **Note that** the start and end timestamp are all inside an interval. That means for two consequent `start` or `end`, the length of this interval is `time2 - time1`, but for a consequent `start`, `end` pair, it's `time2 - time1 + 1`. |
| LeetCode 439  | Ternary Expression Parser                | Medium     | Simlar to `Reverse Polish Notation`. But we can solve this question by iterating from the tail and every time we meet a `?`, we pop two values from our stack and do calculation. Another way is to divide the original string into two blocks and get the answer recursively. |
| LeetCode 856  | Score of Parentheses                     | Medium     | **Good Question:** Only when we meet a ')', we need to calculate the score of this pair of parenthese. And if the current inner score is 0, that means there's no inner parentheses inside, we just increase by 1; if the current inner score is larger than 0, we know there're some terms inside, we need to double the score. And when we meet a '(', we should push a `0` into the stack. It just represents the score of its inner part. |

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
| LeetCode 75   | Sort Colors                                                  | Medium     | Use two pointers to point to the next index for inserting `0` and `2` respectively. Then use another pointer to iterate the whole array. **Note that** after swapping with 2, we need move back `i` by 1, since for the index `q` it has not been scanned yet so it might be `0` or `2` and it's required to be checked while for the index `p` it must be `1`, so it doest need any extra check. |
| LeetCode 826  | Most Profit Assigning Work                                   | Medium     | Sort `difficulty & profit` pairs and `worker`. Then use one pointer to iterate the `difficulty & profit` pairs, another pointer to iterate `worker`. While iterating, use two variables `sum` and `maxProfit` to record the current profit sum and the current max profit. |
| LeetCode 633  | Sum of Square Numbers                                        | Easy       | Calculate square value of every number less than `sqrt(c)`. Then use two pointers approach to check whether there's a pair sum up to `c`. |

<br/>

## Sliding Window

| #            | Title                                                        | Difficulty | Comment                                                      |
| ------------ | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 76  | Minimum Window Substring                                     | Hard       | **Sliding window**: 1. Use two pointers: start and end to represent a window; 2. Move end to find a valid window; 3. When a valid window is found, move start to find a smaller window. |
| LeetCode 239 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum) | Hard       | 1⃣️ Use a Deque to store the index of elements in sliding window; the elements in Deque is descend, so the maximum occurs in the head, minimum occurs in the end; in each round of loop, we only keep the "promising" elements in the Deque. 2⃣️ Use a prefix max array with a boundary on `index % k == 0` |
| LeetCode 438 | Find All Anagrams in a String                                | Medium     | First expand the window to cover a possible answer, then shrink the window. Use a variable `incomplete` to record how many kinds of letters there're still not covered by the current window. When `incomplete == 0`, shrink and check whether the current window length is equal to `q.length()`. If it's equal, add the current `start` into the result set. Then destroy the state of `incomplete == 0` by expanding `end` of the window. |
| LeetCode 713 | Subarray Product Less Than K                                 | Medium     | the number of subarrays that ends at index `end` is just the window size. Therefore, the total number is just the sum of every valid window's size. |
| LeetCode 424 | Longest Repeating Character Replacement                      | Medium     | extend the window until the sum of all non-maximum cnt is greater than k, record the window length; shrink the window until it is valid again; Use a helper function to check it. **Note that** we can also check it by using `end - start` to represent the `totalCnt`, using `maxCnt` to record the `maxCnt`. Notice that here `maxCnt` is not an accurate max count, since we only care the longest window and when we shrink, the current window must not be able to be the longest window. So we only care the historical `maxCnt`, not the accurate current `maxCnt`. |

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
| LeetCode 274 | H-Index                    | Medium     | We can use the idea of bucket to resolve this question instead of sorting the original array. Since `h` is in the range [0, n], we can count papers by citation. For papers with citation larger than `n`, we collect them in the `bucket[n]`. So we will have n+1 buckets in total. Then iterate the bucket from the tail and h from n decreased to 0 until the accumulative count sum is larger than `h`. |

<br/>

## Greedy

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 406  | Queue Reconstruction by Height                               | Medium     | Descending sort array by height; for people having same height, ascending sort by index; Then, insert the elements of the sorted array; in each iteration, the current element must be the smallest element due to descending sorting, so just call the method `add(p[i], p)` of LinkedList |
| LeetCode 621  | [Task Scheduler](https://leetcode.com/problems/task-scheduler) | Medium     | https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation; https://github.com/tzheng/interviewprep/blob/master/SourceCode/TaskCoolDown.java |
| LeetCode 1167 | Minimum Cost to Connect Sticks                               | Medium     | Use a min heap to store the elements. Each time poll two minimal elements from the heap until there's only 1 element left in the heap. Return the total cost. |
| LeetCode 1024 | Video Stitching                                              | Medium     | Similar to `LeetCode 1326`. But it's not that good to use DP to solve this problem. It takes `O(nT)` while greedy takes `O(nlog(n))`. See details in the code. |
| LeetCide 55   | Jump Game                                                    | Medium     | Use two pointers: `cur` represents the current index, `end` represents the current farthest index we can reach. If finally `end` can reach the tail of the array, return true. |
| LeetCide 45   | Jump Game II                                                 | Medium     | Greedy but actually is the transformation of BFS. Use a variable `end` to record the current end of this level of BFS; use another variable `reach` to record the current farthest index we can reach. Every time we scan to the index `cur  == end` that means we finish one level of BFS, so we can increase `ans` by one and set the current end to the current farthest reachable index. |
| LeetCode 1353 | Maximum Number of Events That Can Be Attended                | Medium     | Since there's no priority order among these events (i.e. any event can be selected in a specific day), we can solve this question by always selecting the most recently due event. We can first sort the original array by start date, so that when we iterate by days we can select the events that start from the current date easily. Then use a PriorityQueue to extract the event which dues first. Then every time, we push the events started from the current date into the PriorityQueue, extract one event ended first, and pop all events that due today. **Note that** the while loop can not end until both all events iterated and the PriorityQueue is empty. |
| LeetCode 1055 | Shortest Way to Form String                                  | Medium     | Use greedy to expand each partition to the most. We can use two pointers, one to iterate `source`, another for `target`. We can use a dictionary of size 26 to record the occurrence of each letter (its index). When iterating `target`, we can use this dictionary to find the next in `source` by binary search since the indices will always occur in ascending order. It takes O(log(M/26) * N). Further, we can flat the value of the dictionary entry from `a ->{1,3,7,11}` to `a ->{1,1,3,3,7,7,7,7,11,11,11, 11,0,0, 0}` if the target is of length 15. If we need to get the next pos of `a` in `source` for the current index 8, we can just access `dict[a][8]`. It takes O(M+N). |
| LeetCode 991  | Broken Calculator                                            | Medium     | DP doesn't work since the lower state will rely on the higher state. So we consider greedy. The decrement actions in the high value level must have less influence compared to doing decrement in the lower value level, since the double actions will amplify the decrement actions in the lower value level. See more explanation in the code. |

<br/>

## Hash Table

| #             | Title                              | Difficulty | Comment                                                      |
| ------------- | ---------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode  953 | Verifying an Alien Dictionary      | Easy       | We can compare the first difference of two adjacency words in the List. For example, `"applying"` and `"apples"` have a first difference of `y` vs `e`. Then check wheter the character in first word is before that in the second word. Pay attention to this special case: `apple <-> app`. |
| LeetCode 387  | First Unique Character in a String | Easy       | One pass solution: Use a LinkedHashMap to store the unique \<element, index\> pairs and a HashSet to check whether this element has occurred before. |
| LeetCode 49   | Group Anagrams                     | Medium     | Count letters and then generate a key string using the count in the first step. |
| LeetCode  437 | Path Sum III                       | Easy       | PrefixSum on Binary Tree. Use DFS and a HashMap to record the prefix sums. Notice that HashSet may neglect some cases. |
| LeetCode 1152 | Analyze User Website Visit Pattern | Medium     | Use a hashmap to group elements by username. Then sort the elements in each group by timestamp. After sorting, iterate all possible 3-seqs in the brute-force approach and count the occurrence of each 3-seq. Finally, return the most frequently visited one. **Notice that** we need to use a hashset to remove duplicates inner the same user. (See more details in the code comment.) |
| LeetCode 409  | Longest Palindrome                 | Easy       | sum up all even counts and the (odd-1) counts. If there's any odd counts, increase the final result by 1. See how to use hashset to resolve this question in the code. |

<br/>

## Dynamic Programming

| #              | Title                                            | Difficulty | Comment                                                      |
| -------------- | ------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 312   | Burst Balloons                                   | Hard       | 1. Denote dp\[i]\[j] as the maximum gain for bursting the balloons from i to j; 2. Get recursive equation; 3. Iterate from length 0 |
| LintCode 92    | Backpack                                         | Medium     | Classical knapsack problem; denote dp\[i]\[j] as the max weight for the first i items with backpack of j size; So for the i th item, it will have two cases: in or out; dp\[i]\[j] = max(dp\[i-1]\[j], dp\[i-1]\[j-A\[i]] + A\[i]); **space complexity can be O(V)** |
| LeetCode 494   | Target Sum                                       | Medium     | DFS or DP; just see as a knapsack problem; test cases should include `[0,0,0,0,1], 1`; map index [-sum, sum] to [0, 2*sum]; when initializing, `++` the dp\[0]\[-num\[i]] instead of assigning 1 |
| LeetCode 279   | Perfect Squares                                  | Medium     | problem of `n` can be divided into the subproblem of `n-square[i]`  + 1; Time complexity is O(n*sqrt(n)) |
| LeetCode 120   | Triangle                                         | Medium     | Take care that how to represent the index relationship between the last level index and the current level index: `dp[i][j] consists of dp[i-1][j-1] & dp[i-1][j]`. To meet the O(n) space complexity requirement, we can maintain the dp[] in a *bottom-to-top* approach. In the end, return dp[0]. |
| LeetCode 1223  | Dice Roll Simulation                             | Medium     | A little bit difficult. Notice that rollMax represents the max consecutive times. See comments. |
| LeetCode  1102 | Path With Maximum Minimum Value                  | Medium     | Dijkstra's algorithm. Use a max heap to store the fringes. Use a boolean array to restore whether a point is visited. Once a point is in tree, it will not be modified again. Then just return. |
| LeetCode 264   | Ugly Number                                      | Medium     | Use 3 variables to store the current product for facter `2, 3, 5` respectively. |
| LeetCode 62    | Unique Paths                                     | Medium     | `dp[i][j] = dp[i-1][j] + dp[i][j-1]`                         |
| LeetCode  63   | Unique Paths II                                  | Medium     | The trasition equation is still `dp[i][j] = dp[i-1][j] + dp[i][j-1]`. The only difference is how to treat the obstacles. |
| LeetCode 516   | Longest Palindromic Subsequence                  | Medium     | Transition equation: `dp[i][j] = dp[i+1][j-1] + 2 or max(dp[i+1][j], dp[i][j-1])`. Start from `len = 1` to `len = n`. We can also reduce the space from `O(n^2)` to `O(n)` by recording the last state's leftmost dp element. (The dp array is updated like a triangle) |
| LeetCode 1326  | Minimum Number of Taps to Open to Water a Garden | Hard       | **1.** DP: `dp[i] = min(min(dp[start...i-1]) + 1 => dp[i]) = min(dp[start] + 1, dp[i])`, since dp[] must be ascending, so dp[start] must be the smallest one among dp[start...i-1]. **2.** Greedy: Sort the segments and then extend the possible maximal range step by step.(See the code.) |
| LeetCode 276   | Paint Fence                                      | Easy       | Similar to `1223 Dice Roll Simulation `. The transition equation is `same[i] = diff[i-1]` and `diff[i] = k * sum(same[i-1], diff[i-1]) - same[i-1] - same[i] = (k-1) * sum`. |
| LeetCode 416   | Partition Equal Subset Sum                       | Medium     | It's a knapsack problem. `dp[i][j]` => whether we can use the first i elements to sum up to j. The transition equation is `dp[i][j] = dp[i-1][j-num[i]]`. The initialization state is `dp[i][j] = true, j = 0`. And we can reduce the space complexity to `O(sum)`. But notice that when iterating the states, we should start from the tail to the head, since if we update the lower elements first, it will impact the updatement of the higher elements. |
| LeetCode 718   | Maximum Length of Repeated Subarray              | Medium     | State definition: `dp[i][j] => the maximum length of the repeated subarray that ends at i for A, at j for B`. State Transition: `dp[i][j] = (A[i] == B[j]) ? dp[i-1][j-1] + 1 : 0`. State initialization: ``dp[i][j] = 0, i = 0 || j = 0`. |
| LeetCode 712   | Minimum ASCII Delete Sum for Two Strings         | Medium     | This question is equivalent to maximum ASCII sum common String. State definition: `dp[i][j] => the maximum ASCII sum of common subsequence for s1.substring(0, i) and s2.substring(0, j)`. State transition: `dp[i][j] = (s1[i] == s2[j]) ? dp[i-1][j-1] + ASCII(s1[i]) : max(dp[i-1][j], dp[i][j-1])`. State initialization: ``dp[i][j] = 0,   i = 0 || j = 0`. Time complexity: O(mn) |
| LeetCode 651   | 4 Keys Keyboard                                  | Medium     | To maximize the total count of `A`, in the last series of actions we must do like this `*A, *C, V, V, V,... `. So we can get `dp[i] = max(i, max(dp[k] * (i - k - 1)));  k in [0, i-3]` . And we initialize `dp[0] = 0 `. It takes O(n) time. |
| LeetCode 1140  | Stone Game II                                    | Medium     | **A question of game theory.** The more scores Alex gets, the less scores Lee gets, since the total scores is fixed. Our task is to get the maximum scores Alex can get. So it's equivalent to get the maxium difference between Alex and Lee. See more details in the code. |
| LeetCode 650   | 2 Keys Keyboard                                  | Medium     | Similar to `LC 651`. State definition: `dp[i] => the minimum steps to reach i`. State transition: `dp[i] => min(dp[j] + i/j),   j is the factor of i`. Initializing: `dp[1] = 0`. It can also be solved by greedy. Because copy the more As will always save more steps. So we can always choose the max factor to generate our result. |

<br/>

## Trie

| #             | Title                                                        | Difficulty | Comment                                                      |
| ------------- | ------------------------------------------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 208  | [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree) | Medium     | TrieNode(links[R], R = 26, isEnd).                           |
| LeetCode  642 | [Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system) | Hard       | Record the words and its times in each node. Then use a max heap to return top 3. |
| LeetCode 1268 | Search Suggestions System                                    | Medium     | `class Trie {private Trie[] links = new Trie[26]; List<String> suggestion = new ArrayList<>();}`. Notice that we're required to return 3 candidates at most. **This problem also can be solved using binary search**. |
| LeetCode 421  | Maximum XOR of Two Numbers in an Array                       | Medium     | In order to get a maximum XOR, we need to get a most different prefix from the left. So we can use trie to get it. There're some tricks: **1.** Use `Integer.toBinaryString()` to convert integers to a  bit represented string. **2.** use `Integer.toBinaryString(nums[i] | highBitMask).substring(1)` to keep a `0000..` prefix for the small numbers. **3.** update the maximum XOR in every insertion. |
| LeetCode 720  | Longest Word in Dictionary                                   | Easy       | Trie + DFS                                                   |
| LeetCode 648  | Replace Words                                                | Medium     | Contruct trie and then use the trie to filter words.         |

<br/>

## Math

| #             | Title                           | Difficulty | Comment                                                      |
| ------------- | ------------------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 263  | Ugly Number                     | Easy       | Decomposing prime factor by 2, 3, 5                          |
| LeetCode 445  | Add Two Numbers II              | Medium     | Add two numbers which are stored in two linked list. Use two stacks to solve it. Don't forget to check carry after while loop. |
| LeetCode 957  | Prison Cells After N Days       | Medium     | Similar to `Game of Life`. But there must be a cycle in this question, since we only have 2^8 possible states. So if N is larger than 2^8, definitely it must have two same states and then it will lead to a cycle. Therefore, our problem now is becoming a question of finding a cycle. We can use a HashSet\<String\> to store the current states we have. The key is generated by `Arrays.toString()`. Note that we don't need to add the initial state into the hashSet, since we don't know whether the initial state is a part of the cycle. We can prove that not adding the initial state can calculate the cycle properly. (See comments) |
| LeetCode 204  | Count Primes                    | Easy       | The Sieve of Eratosthenes Algorithm. The core of this algorithm is to mark the numbers as non-primes starting from i\*i. See [Sieve of Eratosthenes Algorithm](https://leetcode.com/static/images/solutions/Sieve_of_Eratosthenes_animation.gif). Starting from 2 until sqrt(n), for each number, if it is prime, mark the number starting from \*i to n as non-primes, in each step of the iterations, increase i by i. Finally, counting all the primes from 2. |
| LeetCode  866 | Prime Palindrome                | Medium     | All even palindrome numbers are non-primes. See [All Even Length Palindrome are Divisible by 11](https://leetcode.com/problems/prime-palindrome/discuss/146798/JavaC%2B%2BPython-All-Even-Length-Palindrome-are-Divisible-by-11). Checking whether a number is prime takes O(sqrt(n)) time, while checking whether a number is palindrome takes O(log(n)) time. So we first form a palindrome greater than N, then check if it is a prime. We can form a odd palindrome number by forming a halve and reversing it (remove the first digit since we need a odd palindrome), then concatenating the two part. Finally, judge whether the gernated number is greater than N and whether it is a prime. |
| LeetCode  168 | Excel Sheet Column Title        | Easy       | Similar to getting each digit in a decimal.                  |
| LeetCode 1323 | Maximum 69 Number               | Easy       | One solution is to convert the integer to a String, then do modification. Another idea is to read the integer's digits from high to low. See how to do it in the code. |
| LeetCode 523  | Continuous Subarray Sum         | Medium     | Find a subarray (size is at least 2) which sums up to `k * n`, n can be any integer (include e.g. -2, 0, 1, ...). The core idea is that first we get the moded prefix sum array since `(sum + n * k) % k <=> sum % k `, then if there's a pair that two prefix sums have the same value, return true. **Note that** the size of the subarray must be larger than 1, so we require a `HashMap` to record the sum and its first occurring index. And be careful to handle the corner cases (see code comments). Think about why we need to put a `(0, -1)` when initializing the hashmap. |
| LeetCode  537 | Complex Number Multiplication   | Medium     | Split by `\\+|i` and it will only generate two parts: one is the real number, the other is the imaginary number. |
| LeetCode 1015 | Smallest Integer Divisible by K | Medium     | Why only iterating from [1, K]? Why not 2 and 5?<br/>    - Suppose we have two 11..11 number a & b which have the same remainder by K,  so a % k = b % k  and  a - b = 111..10000 (a-b ones & b zeros) => (a - b) % k = 0.  Since we have iterated to a, a must be larger than a - b, so the left part 111...1 (a - b ones) in 11..000, can not be divided by K, so now we only remain the right  part 1000..0 (b zeros). 1000..0 (b zeros) only have two factors: 2 & 5. So if K is not multiple of 2 and 5, there can not be the case that has same remainders. |
| LeetCode 202  | Happy Number                    | Easy       | Only have two cases for a happy number: one is having a cycle, the other is ending in 1. How to prove? Since the square of each digit can only be 81 at most (which is less than 100), the sum of all digits' square must be less than `100*n`. For the numbers having 3 or more digits, the sum must be smaller than the number itself. So this transformation will reduce the original number. So it must have duplicate when the range shrinks. |

<br/>

## Graph

| #            | Title                    | Difficulty | Comment                                                      |
| ------------ | ------------------------ | ---------- | ------------------------------------------------------------ |
| LeetCode 997 | Find the Town Judge      | Easy       | The judge's out-degree must be zero and it's indegree must be `N-1`. |
| LeetCode 277 | Find the Celebrity       | Medium     | Similar to `LeetCode 997`. Intuitively, we need to check whether there's a node whose in-degree is `N-1` and out-degree is `0`. It takes O(n^2). But we have a two-pass approach to solve this problem. In the first pass, we can record the one which isn't connected by any vertex. Then, in the second pass, we can check whether there's another vertex connecting to this candidate vertex. **Note that **a special case is that there're two candidates (e.g. there're two connected components), so in the second pass we need to check `knows(celebrity, i) || !knows(i, celebrity)` to avoid wrong answer in this case. |
| LeetCode 433 | Minimum Genetic Mutation | Medium     | Construct graph then use BFS to get the shortest distance. **There's a trick** in this question for getting neighbors in the graph. Instead of compare every string in the bank, since the letters for DNA can only by in `A, C, G, T`, we can use two sets `bankSet & visitedSet` to store the bank and the visited set. Then we start at the start string, change one letter in the string and check whether it is in the bank set. If exist, there's an edge. |

<br/>

## System Design

| #            | Title                   | Difficulty | Comment                                                      |
| ------------ | ----------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 382 | Linked List Random Node | Medium     | **Reservoir Sampling.** We can use this algorithm without knowing the size of the dataset to randomly pick `k` elements. For the first `k-th` elements, we just put them into the `reservoir` directly. For the `(k+1)-th to n-th` elements, we will have a probability of `k/(k+i)` to select it and a probability of `1/k` for each element  already in the reservoir to be replaced by the `(k+i)-th` element. See the proof in the code. |
|              |                         |            |                                                              |
|              |                         |            |                                                              |

<br/>

## Other

| #            | Title                   | Difficulty | Comment                                                      |
| ------------ | ----------------------- | ---------- | ------------------------------------------------------------ |
| LeetCode 418 | Sentence Screen Fitting | Medium     | **Good Question.** Precomputing that if a line started from sentence[i] in the begining of the line: `1.` how many times the sentence can be filled in; `2.` which word will be the beginning word for the next line. |
|              |                         |            |                                                              |
|              |                         |            |                                                              |

