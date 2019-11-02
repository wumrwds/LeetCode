# Game of Life

### space O(n)

I guess we can just create a function to count the live neighbors. Iterate all points in our 2D board, count for each point, then use the given rules to update our matrix. Maybe we need a new copy of for this array. And the update operations should be made in the copy. Beacause if we count while also updating, it will cause some data inconsistent problems. So Maybe we'd better to count all neighbors for each point first, then update the matrix together after finishing counting.



### Space O(1)

So you mean we can't use extra O(n) space. we can't create a new array. And we need to update in place.

The key is after we update, it can't infulence the count result for the nearby points. Let me see how we can get it.

Maybe we can use some mapping to mark it. For example, we can use "+" to represent from 0 to 1, use "-" represent from 1 to 0. Then we can first update our array to this labels, then after finishing counting, we iterate our array again and set the labels to 0 and 1.



### Infinite border

So what does it means?  (Memory is not enough)

Suppose we have 1M * 1M board, how to do that?

I think this case is just like the scenario about sorting in disk. We need to split the data into several parts and each parts can be stored in our memory. Then we sort each part of data in the memory and restore them into disk. Then we retrieve the top elements of each part and merged this sorted parts.

So I guess this question we can use the same idea.

The data scale is about 10^6 * 10^6 * 4 byte = 4 * 10^12 byte = 4 TB (if we use boolean to represent 0 or 1 here, we can only use 1 TB to do it). Suppose we have a 16G memory and a 4 TB disk. 

First we a small part of data which we can store in memory, then update it. Finally we merge this result to the matrix we want. 







