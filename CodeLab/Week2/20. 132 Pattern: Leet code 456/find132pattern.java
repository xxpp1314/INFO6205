class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3)
            return false;
        int t = nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > t){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] > nums[j] && nums[j] > t)
                        return true;
                }
            }
            else
                t = nums[i];
        }
        return false;
    }
}
