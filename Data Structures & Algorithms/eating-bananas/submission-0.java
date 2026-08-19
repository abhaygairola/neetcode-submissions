class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        int target =h;
        int res=0;

        for (int i : piles) {
            maxPile = Math.max(maxPile, i);
        }
        int l = 1, r = maxPile;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midh=0;
            for (int i : piles) {
                midh+= Math.ceil((double)i/mid);
            }
            if(target<midh){l=mid+1;}
            else if(target>=midh){res=mid;r=mid-1;}
        }
        return res;
    }
}
