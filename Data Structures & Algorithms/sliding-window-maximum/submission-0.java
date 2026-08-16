class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int l=0,r=0;    
        Deque<Integer> dq = new LinkedList<>(); 
        while(r<n){
            while(!dq.isEmpty() && nums[dq.getLast()]<nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);
            if(!dq.isEmpty() && l>dq.getFirst()){
                dq.removeFirst();
            }

            if(r+1>=k){
                res[l]=nums[dq.getFirst()];
                l++;
            }
            r++;

        }
        return res;
        
    }
}
