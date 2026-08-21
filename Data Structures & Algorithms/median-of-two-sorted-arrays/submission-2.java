class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2 ;
        int half = (total+1) / 2;

        int l = 0, r = n1;

        while (l <= r) {
            int amid = l + (r - l) / 2;
            int bmid = half - amid;
            int aleft = amid > 0 ? nums1[amid - 1] : Integer.MIN_VALUE;
            int aright = amid < n1 ? nums1[amid] : Integer.MAX_VALUE;
            int bleft = bmid > 0 ? nums2[bmid - 1] : Integer.MIN_VALUE;
            int bright = bmid < n2 ? nums2[bmid] : Integer.MAX_VALUE;

            if (aleft <= bright && bleft <= aright) {
                if (total % 2 == 0) {
                    return (Math.max(aleft,bleft)+Math.min(aright,bright))/2.0;
                } else {
                    return Math.max(aleft,bleft);
                }
            } else if (aleft > bright) {
                r = amid - 1;
            } else {
                l = amid + 1;
            }
        }
        return -1;
    }
}
