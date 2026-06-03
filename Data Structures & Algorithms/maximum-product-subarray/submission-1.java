class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int preProd = 1;
        int sufProd = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (preProd == 0)
                preProd = 1;
            if (sufProd == 0)
                sufProd = 1;
            preProd *= nums[i];
            sufProd *= nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(preProd, sufProd));
        }
        return maxProd;
    }
}
