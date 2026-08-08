class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n :nums){
            if(s.contains(n)) return true;
            else s.add(n);
        }
        return false;
        
    }
}