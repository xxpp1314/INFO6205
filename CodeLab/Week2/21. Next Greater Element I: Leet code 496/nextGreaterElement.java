class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {  
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = nextGreaterHelper(nums2);      
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    private Map<Integer, Integer> nextGreaterHelper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();  
        for (int i = nums.length - 1; i >= 0; i--) {  
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  
            }

            map.put(nums[i], stack.isEmpty() ? -1 : stack.peek()); 
            stack.push(nums[i]);  
        }

        return map;
    }
}
