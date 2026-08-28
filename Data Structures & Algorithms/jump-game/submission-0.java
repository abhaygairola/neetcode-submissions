class Solution {
    public boolean canJump(int[] nums) {
        int reach =nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]>=reach-i)reach =i;
        }

        return reach==0;
        
    }
}
