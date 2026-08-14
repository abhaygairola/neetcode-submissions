class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lmax = height[l], rmax = height[r];
        int water = 0;
        while (l < r) {
            if (lmax < rmax) {
                water += lmax - height[l];
                l++;
                lmax = Math.max(lmax, height[l]);
            } else {
                water += rmax - height[r];
                r--;
                rmax = Math.max(rmax, height[r]);
            }
        }
        return water;
    }
}
