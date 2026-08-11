class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int res =1;

        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        for(Integer n : s){
            int l = 1;
            if(!s.contains(n-1)){
                while(s.contains(n+l)){
                    l++;
                }
                res = Math.max(l,res);
            }
        }
        return res;
        
    }
}
