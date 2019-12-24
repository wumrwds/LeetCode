class Solution {
    /*
    example 1:
    [10,20,30,40, 1,2,3,4, -5, -4, -3, -1, 35]
    
    top -> 
    [10:10 ]
    [10:20 ]
    [10:30 ]
    [10:40 ]
    [1:1 , 10:40 ]
    [1:2 , 10:40 ]
    [1:3 , 10:40 ]
    [1:4 , 10:40 ]
    [-5:-5 , 1:4 , 10:40 ]
    [-5:-4 , 1:4 , 10:40 ]
    [-5:-3 , 1:4 , 10:40 ]
    [-5:-1 , 1:4 , 10:40 ]
    
    merge [-5: 35] and [1:4] in the last step
    [-5:35, 10:40]
    
    eaxmple 2:
    [1,2,3,4, 10,20,30,40, -5, -4, -3, -1, 35]
    
    [1:1 ]
    [1:2 ]
    [1:3 ]
    [1:4 ]
    [1:10 ]
    [1:20 ]
    [1:30 ]
    [1:40 ]
    [-5:-5 , 1:40 ]
    [-5:-4 , 1:40 ]
    [-5:-3 , 1:40 ]
    [-5:-1 , 1:40 ]
    
    In this stack, the min-max pair with less value must occur after the greater ones.
*/
    public boolean find132pattern(int[] nums) {
        
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < stack.peek()[0]) {
                stack.push(new int[]{nums[i], nums[i]});
            }
            // skip  nums[i] == stack.peek()[0]
            else if (nums[i] > stack.peek()[0]) {
                if (nums[i] < stack.peek()[1]) {
                    return true;
                }
                else if (nums[i] > stack.peek()[1]) {
                    int[] last = stack.pop();
                    while (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
                        stack.pop();
                    }
                    // check the last element in the stack with max > nums[i]
                    if (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                        return true;
                    }
                    
                    last[1] = nums[i];
                    stack.push(last);
                }
            }
        }
        
        return false;
    }
}