## 236. Lowest Common Ancestor of a Binary Tree

### Analysis

Our task is to find the lowest common ancestor of two nodes in a binary tree. To solve this question, as it's a tree question, first i'd like to have a try with recursion and divide conquer.

We can call this method recursively on the left subtree and right subtree. And what we need to do is just to determine the result for root by using the results of left subtree and right subtree.

OK. Before we get started, I guess I'd like to go through some examples first. I think it will help me to generate my solution.

First, think about it. We have a tree like this one:

```
     3
   /   \
  p    20
      /   \
     15    q
```

Obviously, the lca is the root 3.

Then, we look at this one:

```
         3
      /    \
    20      9
  /   \    / \
 p     q  10 11
```

So the lca is 20.

So we can conclude that if both p and q are in left or right subtree, the lca is `lca(root.left/right)`; if one is in left and another is in the right, the lca is the root.

Then we should talk about the return value of this function. If we use the definition of our original question, this method will return the lca node. So if we call recursively in our first example, the left subtree will get a null, right also a null, since there's only a node in this subtree. It will be the same value as the invocation of the right subtree in our second example. You see, the subtree 9 10 11, as there's no node p and q in this subtree, it will return null. 

In order to distinguish these two cases, I think we can modify it to return the root when there's only one node in the subtree.

```
     q
   /   \
  p    20
```

