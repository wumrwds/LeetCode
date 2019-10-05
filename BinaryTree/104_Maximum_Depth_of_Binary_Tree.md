## 111 Maximum Depth of Binary Tree

### Analysis

Our task is to find the maximum depth of binary tree, and the depth of a binary tree is the length of a path from the root down to the leaf. 

To find the maximum depth of a binary tree, we can use recursion and the divide & conquer idea. 

We can compute the depth of both left node and right node of the root by calling the function recursively. Then the depth of the root would be the maximum depth of the left subtree and right subtree plus one, since now we add the current root into the path, so the depth will plus one. And for the root node is empty, we just return 0.



------

### Coding

First we create a method called `maxDepth` that takes parameters `TreeNode root` (this parameter represents the root of a binary tree) . And this method will return the maximum depth with type int.

Then as I mentioned before, we will first check the depth of both the two children of the tree. 

So the maximum depth of root will be the maximum of left depth and right depth plus 1.

Finally, we handle the null case. If it pass a tree node equals to null, it will not have a valid path. So the depth is 0.

```java
// 1. First we create a method called `maxDepth` that takes parameters `TreeNode root` (this parameter represents the root of a binary tree) . And this method will return the maximum depth with type int.
public int maxDepth(TreeNode root) {
    // 
    if (root == null) {
        return 0;
    }
    
    // 2. Then as I mentioned before, we will first check the depth of both the two children of the tree. It's here the recusion comes in. We call the method itself and pass a parameter root's left subtree and root's right subtree. 
    // The maximum depth of left subtree will be held by an int variable called leftDepth
	int leftDepth = maxDepth(root.left);
	int rightDepth = maxDepth(root.right);
    
    // 3. So the maximum depth of root will be the maximum of left depth and right depth plus 1, as now we add root into our path.
    return Math.max(leftDepth, rightDepth) + 1;
}
```



--------

### Time Complexity

As the algorithm traverse all the nodes of this tree, and each traversal cost O(1) time. So I guess the overall time complexity is O(n). And n represents the number of nodes in this binary tree.