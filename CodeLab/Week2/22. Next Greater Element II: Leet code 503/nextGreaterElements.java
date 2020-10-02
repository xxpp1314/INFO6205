class Solution {
 public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for(int i = 0; i < 2 * nums.length - 1; i++) {
            int index = i % nums.length; 
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) { 
                res[stack.pop()] = nums[index]; 
            }
            stack.push(index);         
        }
        return res;
    }
}
